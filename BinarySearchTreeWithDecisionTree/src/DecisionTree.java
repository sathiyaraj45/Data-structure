
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author Sathiyaraj created on 04-02-2022
 * <p>
 * TODO
 */
public class DecisionTree {

    //Private binary node class
    private class BinaryTree {
        //Local variable
        private int nodeInfo;
        private String questionAndAnswer;
        private BinaryTree yesBranch;
        private BinaryTree noBranch;

        //Node Constructor
        public BinaryTree(int nodeInfo, String questionAndAnswer) {
            this.nodeInfo = nodeInfo;
            this.questionAndAnswer = questionAndAnswer;
        }
    }
    //Root node declared
    BinaryTree rootNode = null;
    static BufferedReader keyboardInput = new
            BufferedReader(new InputStreamReader(System.in));

    //Decision tree constructor
    public DecisionTree() {
    }

    //Root Node Creation
    public void addRootNode(int nodeInfo, String questionAndAnswer) {
        rootNode = new BinaryTree(nodeInfo, questionAndAnswer);
    }

    //Yes/No Branch Node Creation
    public void addYesOrNoBranchNode(int existingNodeInfo, int newNodeInfo, String questionAndAnswer, String nodeType) {
        if(rootNode == null) {
            System.out.println("Root not is not available, Plz add root node first");
            return;
        }

        //Search root node and add branch node
        if(searchNodeAndAddNode(rootNode, existingNodeInfo, newNodeInfo, questionAndAnswer, nodeType)) {
            System.out.println("Added new node "+ nodeType +" onto "+ existingNodeInfo);
        } else {
            System.out.println("Root "+ existingNodeInfo +" not available");
        }
    }

    private boolean searchNodeAndAddNode(BinaryTree currentNode, int existingNodeInfo, int newNodeInfo, String questionAndAnswer, String nodeType) {
        if(currentNode.nodeInfo == existingNodeInfo) {
            if(nodeType.equals("left")) {
                if(currentNode.yesBranch == null) {
                    currentNode.yesBranch = new BinaryTree(newNodeInfo, questionAndAnswer);
                } else {
                    System.out.println("Override " + currentNode.yesBranch.nodeInfo + "left branch");
                    currentNode.yesBranch = new BinaryTree(newNodeInfo, questionAndAnswer);
                }
            } else {
                if(currentNode.noBranch == null) {
                    currentNode.noBranch = new BinaryTree(newNodeInfo, questionAndAnswer);
                } else {
                    System.out.println("Override " + currentNode.noBranch.nodeInfo + "right branch");
                    currentNode.noBranch = new BinaryTree(newNodeInfo, questionAndAnswer);
                }
            }
            return true;
        } else {
            //Try if yes branch exist
            if(currentNode.yesBranch != null) {
                if(searchNodeAndAddNode(currentNode.yesBranch, existingNodeInfo, newNodeInfo, questionAndAnswer, nodeType)) {
                    return true;
                } else {
                    //Try if no branch exist
                    if(currentNode.noBranch != null) {
                        return (searchNodeAndAddNode(currentNode.noBranch, existingNodeInfo, newNodeInfo, questionAndAnswer, nodeType));
                    } else {
                        return false;
                    }
                }
            }
            return false;
        }
    }

    public void queryBinaryTree() throws IOException {
        queryBinaryTree(rootNode);
    }

    private void queryBinaryTree(BinaryTree currentNode) throws IOException {
        if (currentNode.yesBranch==null) {
            if (currentNode.noBranch==null) System.out.println(currentNode.questionAndAnswer);
            else System.out.println("Error: Missing \"Yes\" branch at \"" +
                    currentNode.questionAndAnswer + "\" question");
            return;
        }
        if (currentNode.noBranch==null) {
            System.out.println("Error: Missing \"No\" branch at \"" +
                    currentNode.questionAndAnswer + "\" question");
            return;
        }
        askQuestion(currentNode);
    }

    private void askQuestion(BinaryTree currentNode) throws IOException {
        System.out.println(currentNode.questionAndAnswer + " (enter \"Yes\" or \"No\")");
        String answer = keyboardInput.readLine();
        if (answer.equalsIgnoreCase("Yes")) queryBinaryTree(currentNode.yesBranch);
        else {
            if (answer.equalsIgnoreCase("No")) queryBinaryTree(currentNode.noBranch);
            else {
                System.out.println("ERROR: Must answer \"Yes\" or \"No\"");
                askQuestion(currentNode);
            }
        }
    }

    public void outputBinaryTree() {
        outputBinaryTree("1",rootNode);
    }

    private void outputBinaryTree(String tag, BinaryTree currentNode) {
        // Check for empty node
        if (currentNode == null) return;
        System.out.println("[" + tag + "] nodeID = " + currentNode.nodeInfo +
                ", question/answer = " + currentNode.questionAndAnswer);
        // Navigate yes branch
        outputBinaryTree(tag + ".1",currentNode.yesBranch);
        // Navigate no branch
        outputBinaryTree(tag + ".2",currentNode.noBranch);
    }
}
