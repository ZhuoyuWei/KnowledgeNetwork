package org.wzy.frame;

public class KNTraining {

	public static KNTraining uniqueInstanse;
	
	public double[][] entity_embedding;
	public double[][] relation_embedding;
	private int entityNum;
	private int relationNum;
	
	private int[][] knGraph;
	private int[][] reverse_knGraph;
	
	
	
	public void ReadKnGraphFromFile(String filename)
	{}
	public void InitEmbeddingFromFile(String embeddingFile)
	{}
	public void Training()
	{}
	
	
	
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
	public int[][] getKnGraph() {
		return knGraph;
	}
	public void setKnGraph(int[][] knGraph) {
		this.knGraph = knGraph;
	}
	public int[][] getReverse_knGraph() {
		return reverse_knGraph;
	}
	public void setReverse_knGraph(int[][] reverse_knGraph) {
		this.reverse_knGraph = reverse_knGraph;
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
