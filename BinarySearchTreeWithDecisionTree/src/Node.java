/**
 * @Author Sathiyaraj created on 04-02-2022
 * <p>
 * TODO
 */


public class Node {
    private int existingNode;
    private int newNode;
    private String questionAndAnswer;
    private String nodeType;

    public Node(int existingNode, int newNode, String questionAndAnswer, String nodeType) {
        this.existingNode = existingNode;
        this.newNode = newNode;
        this.questionAndAnswer = questionAndAnswer;
        this.nodeType = nodeType;
    }

    public int getExistingNode() {
        return existingNode;
    }

    public void setExistingNode(int existingNode) {
        this.existingNode = existingNode;
    }

    public int getNewNode() {
        return newNode;
    }

    public void setNewNode(int newNode) {
        this.newNode = newNode;
    }

    public String getQuestionAndAnswer() {
        return questionAndAnswer;
    }

    public void setQuestionAndAnswer(String questionAndAnswer) {
        this.questionAndAnswer = questionAndAnswer;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    @Override
    public String toString() {
        return "Node{" +
                "existingNode=" + existingNode +
                ", newNode=" + newNode +
                ", questionAndAnswer='" + questionAndAnswer + '\'' +
                ", nodeType='" + nodeType + '\'' +
                '}';
    }
}
