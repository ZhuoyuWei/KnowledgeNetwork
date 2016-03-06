package org.wzy.frame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.wzy.tool.sort.Arrays_2_Comparator;

public class KNTraining {

	public static KNTraining uniqueInstanse;
	
	public double[][] entity_embedding;
	public double[][] relation_embedding;
	
	private int entityNum;
	private int relationNum;
	
	/**
	 * these two int[][][] represent the labeled directed graph.
	 * graph[h_entity_index][it has r,t pairs][2]
	 * graph[][][0] save the relation index
	 * graph[][][1] save the entity index
	 */
	public int[][][] knGraph;
	public int[][][] reverse_knGraph;
	
	
	
	public void ReadKnGraphFromFile(String filename) throws NumberFormatException, IOException
	{
		BufferedReader br=new BufferedReader(new FileReader(filename));
		String buffer=null;
		
		List<int[]>[] graph=new List[entityNum];
		List<int[]>[] rev_graph=new List[entityNum];
		
		for(int i=0;i<entityNum;i++)
		{
			graph[i]=new ArrayList<int[]>();
			rev_graph[i]=new ArrayList<int[]>();
		}
		
		while((buffer=br.readLine())!=null)
		{
			if(buffer.length()<2)
				continue;
			String[] ss=buffer.split("\t");
			if(ss.length!=3)
				continue;
			int[] ers=new int[3];
			for(int i=0;i<3;i++)
			{
				ers[i]=Integer.parseInt(ss[i]);
			}
			
			int[] fpair=new int[2];
			int[] bpair=new int[2];
			fpair[0]=ers[1];
			fpair[1]=ers[2];
			bpair[0]=ers[1];
			bpair[1]=ers[0];
			
			graph[ers[0]].add(fpair);
			rev_graph[ers[2]].add(bpair);
			
		}
		
		br.close();
		
		//sort
		Comparator cmd=new Arrays_2_Comparator();
		for(int i=0;i<entityNum;i++)
		{
			Collections.sort(graph[i],cmd);
			Collections.sort(rev_graph[i],cmd);
		}
		
		
	}
	
	public void InitEmbeddingFromFile(String embeddingFile)
	{
		//has done
	}
	
	public void Training()
	{
		//single thread training
		CompelteTraingingThread ct=new CompelteTraingingThread();
		ct.Training();
		
		//print Embedding
	}
	
	
	
	public double[][] getEntity_embedding() {
		return entity_embedding;
	}
	public void setEntity_embedding(double[][] entity_embedding) {
		this.entity_embedding = entity_embedding;
	}
	public double[][] getRelation_embedding() {
		return relation_embedding;
	}
	public void setRelation_embedding(double[][] relation_embedding) {
		this.relation_embedding = relation_embedding;
	}
	public int getEntityNum() {
		return entityNum;
	}
	public void setEntityNum(int entityNum) {
		this.entityNum = entityNum;
	}
	public int getRelationNum() {
		return relationNum;
	}
	public void setRelationNum(int relationNum) {
		this.relationNum = relationNum;
	}
	
	
	
}
