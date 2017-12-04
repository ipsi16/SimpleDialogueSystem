package bazaar.hint.mts;

public class MonteCarloTreeSearch {
    static final int WIN_SCORE = 10;
    int level;
    int opponent;
 
    public void findNextMove(Dialogue dialogue) {
        // define an end time which will act as a terminating condition
        Tree tree = new Tree();
        Node rootNode = tree.getRoot();
        rootNode.getState().setDialogue(dialogue);
 
        while (System.currentTimeMillis() < end) {
            Node promisingNode = selectPromisingNode(rootNode);
            if (promisingNode.getState().getBoard().checkStatus() 
              == Board.IN_PROGRESS) {
                expandNode(promisingNode);
            }
            Node nodeToExplore = promisingNode;
            if (promisingNode.getChildArray().size() > 0) {
                nodeToExplore = promisingNode.getRandomChildNode();
            }
            int playoutResult = simulateRandomPlayout(nodeToExplore);
            backPropogation(nodeToExplore, playoutResult);
        }
 
        Node winnerNode = rootNode.getChildWithMaxScore();
        tree.setRoot(winnerNode);
        return winnerNode.getState().getBoard();
    }

    private int simulateRandomPlayout(Node node) {
        Node tempNode = new Node(node);
        State tempState = tempNode.getState();
        int dialogStatus = tempState.getDialogue().checkStatus();
        
        while (dialogStatus == Dialogue.IN_PROGRESS) {
            tempState.randomPlay();
            dialogStatus = tempState.getDialogue().checkStatus();
        }
        return dialogStatus;
    }
	
	private void backPropogation(Node nodeToExplore, int playoutResult)
	{
		
	}
}
