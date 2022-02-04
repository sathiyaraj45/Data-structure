
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinarySearchTreeWithDecisionTree {

    static BufferedReader keyboardInput = new
            BufferedReader(new InputStreamReader(System.in));
    static DecisionTree newTree;

    public static void main(String[] args) throws IOException {
        newTree = new DecisionTree();
        // Generate tree
        File inputFile = new File(System.getProperty("user.dir") + "/src/backpain.txt");
        Scanner scan = new Scanner(inputFile);
        List<Node> node = new ArrayList<>();

        while(scan.hasNext()) {
            String line = scan.nextLine();
            String[] list = line.split(",");
            Node obj = new Node(Integer.parseInt(list[0]), Integer.parseInt(list[1]), list[2].replace("\"", ""), list[3].replace("\"", "").trim());
            node.add(obj);
        }
        System.out.println("\nGENERATE DECISION TREE");
        System.out.println("======================");
        node.stream().forEach(obj -> {
            if(obj.getExistingNode() == 0)
                newTree.addRootNode(obj.getNewNode(),obj.getQuestionAndAnswer());
            else
                newTree.addYesOrNoBranchNode(obj.getExistingNode(), obj.getNewNode(), obj.getQuestionAndAnswer(), obj.getNodeType());
        });

        // Output tree
        System.out.println("\nOUTPUT DECISION TREE");
        System.out.println("====================");
        newTree.outputBinaryTree();
        // Query tree
        queryTree();
    }
    // Query tree
    static void queryTree() throws IOException {
        System.out.println("\nQUERY DECISION TREE");
        System.out.println("===================");
        newTree.queryBinaryTree();
        // Option to exit
        optionToExit();
    }

    // Exit program
    static void optionToExit() throws IOException {
        System.out.println("Exit? (enter \"Yes\" or \"No\")");
        String answer = keyboardInput.readLine();
        if (answer.equalsIgnoreCase("Yes")) return;
        else {
            if (answer.equalsIgnoreCase("No")) queryTree();
            else {
                System.out.println("ERROR: Must answer \"Yes\" or \"No\"");
                optionToExit();
            }
        }
    }
}
