import java.awt.*;
import java.awt.event.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/* 
public class Minesweeper {

    
    int tileSize = 70;
    int numRows = 8; 
    int numCols = numRows;
    int boardWidth = numCols * tileSize; 
    int boardHeight = numRows * tileSize;

    //create the window
    JFrame frame = new JFrame("Minesweeper");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();


    int mineCount = 8;
    Random randoom = new Random();

    MineTile[][] board = new MineTile[numRows][numCols];
    ArrayList<MineTile> mineList;

    int tilesClicked = 0; //click all tiles except the one containing mines
    boolean gameOver  =false;

    //create Buttons
    private class MineTile extends JButton {
        int r;
        int c;

        public MineTile(int r, int c){
            this.r = r;
            this.c = c;
        }
        
    }


//Constructor
    public Minesweeper(){

        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setFont(new Font("Arial", Font.BOLD, 25));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Minesweeper:" );
        textPanel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(numRows, numCols));
        // boardPanel.setBackground(Color.BLUE);

        frame.add(boardPanel);

        for(int r = 0; r < numRows; r++){
            for (int c = 0; c < numCols; c++){
                MineTile tile = new MineTile(r, c);
                board[r][c] = tile;

                tile.setFocusable(false);
                tile.setMargin(new Insets(0, 0, 0, 0));
                tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));
                // tile.setText("💣");

                tile.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e){
                        if (gameOver) {
                            return;
                            
                        }
                        MineTile tile  = (MineTile) e.getSource();

                        //left Click
                        if(e.getButton() == MouseEvent.BUTTON1){
                            if(tile.getText() == ""){
                                if(mineList.contains(tile)){
                                    revealMines();
                                }else{
                                    CheckMine(tile.r, tile.c);
                                }
                            }
                        }
                        //right click
                        else if(e.getButton() == MouseEvent.BUTTON3){
                            if(tile.getText() == ""){
                                tile.setText("🚩");
                            }
                            else if(tile.getText() == "🚩"){
                                tile.setText("");
                            }
                        }
                    }
                });
                boardPanel.add(tile);
            }
        }

        setMine();

        //after the load of all component we set visibility true otherwise the component will be loaded randomly(same will be missing)
        frame.setVisible(true);

        
    }

//Mine function
    void setMine(){
        mineList = new ArrayList<MineTile>();

        // mineList.add(board[2][2]);
        // mineList.add(board[2][3]);
        // mineList.add(board[5][6]);
        // mineList.add(board[3][4]);
        // mineList.add(board[1][1]);
        int mineLeft = mineCount;
        while (mineLeft > 0) {
            int r = randoom.nextInt(numRows); // 0 -7 
            int c = randoom.nextInt(numCols); // 0 -7 

            MineTile tile = board[r][c];

            if (!mineList.contains(tile)) {
                mineList.add(tile);
                mineLeft -=1;
            }

        }
    }


//Function to show the bomb when user click on it
    void revealMines(){
        for(int i = 0; i <mineList.size(); i++){
            MineTile tile = mineList.get(i);
            tile.setText("💣");
        }

        gameOver = true;
        textLabel.setText("GAME OVER!");
    }



//Check if there are Mines in neighbrs
    void CheckMine(int r, int c){
        if(r < 0 || r >= numRows || c < 0 || c >= numCols ){
            return;
        }

        MineTile tile = board[r][c];
        if (!tile.isEnabled()) {
                return;
        }

        tile.setEnabled(false);
        tilesClicked +=1;
        int minesFound = 0;

        minesFound += countMine(r-1, c-1);  //top left
        minesFound += countMine(r-1, c);    // top
        minesFound += countMine(r-1, c+1);  //top right

        minesFound += countMine(r, c-1);    // left
        minesFound += countMine(r, c+1);    // right

        minesFound += countMine(r+1, c-1);  //bottom left
        minesFound += countMine(r+1, c);    //bottom 
        minesFound += countMine(r+1, c+1);  //bottom right

        //if there are any mine founded
        if(minesFound > 0){
            tile.setText(Integer.toString(minesFound));
        }else{
            tile.setText(" ");

            //top 3
            CheckMine(r-1, c-1);    //top left
            CheckMine(r-1, c);      //top 
            CheckMine(r-1, c+1);    //top right

            //left and right
            CheckMine(r, c-1);  //left
            CheckMine(r, c+1);  //right

            //bottom 3 
            CheckMine(r+1, c-1);    //bottom left
            CheckMine(r+1, c);    //bottom 
            CheckMine(r+1, c+1);    //bottom right
        }

        if (tilesClicked == numRows * numCols - mineList.size()) {
            gameOver = true;
            textLabel.setText("YOU-WIN");
        }
    }


//How many Mines are in neighbors
    int countMine(int r, int c){
        if(r < 0 || r >= numRows || c < 0 || c >= numCols ){
            return 0;
        }
        if(mineList.contains(board[r][c])){
            return 1; 
        }
        return 0;
    }


    
}*/


/* 
import java.awt.*;
import java.awt.event.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Minesweeper {

    int tileSize = 70;
    int numRows = 8; 
    int numCols = numRows;
    int boardWidth = numCols * tileSize; 
    int boardHeight = numRows * tileSize;

    int mineCount = 8;
    Random randoom = new Random();

    MineTile[][] board = new MineTile[numRows][numCols];
    ArrayList<MineTile> mineList;
    int tilesClicked = 0; //click all tiles except the one containing mines
    boolean gameOver = false;
    boolean gameStarted = false;

    // Timer related variables
    Timer timer;
    int elapsedSeconds = 0;

    //create the window
    JFrame frame = new JFrame("Minesweeper");
    JLabel textLabel = new JLabel();
    JLabel timerLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    //create Buttons
    private class MineTile extends JButton {
        int r;
        int c;

        public MineTile(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    //Constructor
    public Minesweeper(){
        frame.setSize(boardWidth, boardHeight + 100); // Adjusted height for timer
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setFont(new Font("Arial", Font.BOLD, 25));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Minesweeper");
        
        timerLabel.setFont(new Font("Arial", Font.BOLD, 25));
        timerLabel.setHorizontalAlignment(JLabel.CENTER);
        timerLabel.setText("Time: 0s");

        textPanel.setOpaque(true);
        textPanel.setLayout(new GridLayout(2, 1));
        textPanel.add(textLabel);
        textPanel.add(timerLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(numRows, numCols));
        frame.add(boardPanel);

        for(int r = 0; r < numRows; r++){
            for (int c = 0; c < numCols; c++){
                MineTile tile = new MineTile(r, c);
                board[r][c] = tile;

                tile.setFocusable(false);
                tile.setMargin(new Insets(0, 0, 0, 0));
                tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));

                tile.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e){
                        if (gameOver) {
                            return;
                        }

                        if (!gameStarted) {
                            startTimer();
                            gameStarted = true;
                        }

                        MineTile tile  = (MineTile) e.getSource();

                        //left Click
                        if(e.getButton() == MouseEvent.BUTTON1){
                            if(tile.getText().equals("")){
                                if(mineList.contains(tile)){
                                    revealMines();
                                }else{
                                    CheckMine(tile.r, tile.c);
                                }
                            }
                        }
                        //right click
                        else if(e.getButton() == MouseEvent.BUTTON3){
                            if(tile.getText().equals("")){
                                tile.setText("🚩");
                            }
                            else if(tile.getText().equals("🚩")){
                                tile.setText("");
                            }
                        }
                    }
                });
                boardPanel.add(tile);
            }
        }

        setMine();

        // Timer setup
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedSeconds++;
                timerLabel.setText("Time: " + elapsedSeconds + "s");
            }
        });

        //after the load of all component we set visibility true otherwise the component will be loaded randomly(same will be missing)
        frame.setVisible(true);
    }

    // Start the timer
    void startTimer() {
        elapsedSeconds = 0;
        timer.start();
    }

    // Stop the timer
    void stopTimer() {
        timer.stop();
    }

    // Mine function
    void setMine(){
        mineList = new ArrayList<MineTile>();
        int mineLeft = mineCount;
        while (mineLeft > 0) {
            int r = randoom.nextInt(numRows); // 0 -7 
            int c = randoom.nextInt(numCols); // 0 -7 

            MineTile tile = board[r][c];

            if (!mineList.contains(tile)) {
                mineList.add(tile);
                mineLeft -= 1;
            }
        }
    }

    // Function to show the bomb when user click on it
    void revealMines(){
        for(int i = 0; i < mineList.size(); i++){
            MineTile tile = mineList.get(i);
            tile.setText("💣");
        }

        gameOver = true;
        stopTimer();
        textLabel.setText("GAME OVER!");
    }

    // Check if there are Mines in neighbors
    void CheckMine(int r, int c){
        if(r < 0 || r >= numRows || c < 0 || c >= numCols ){
            return;
        }

        MineTile tile = board[r][c];
        if (!tile.isEnabled()) {
            return;
        }

        tile.setEnabled(false);
        tilesClicked += 1;
        int minesFound = 0;

        minesFound += countMine(r-1, c-1);  //top left
        minesFound += countMine(r-1, c);    // top
        minesFound += countMine(r-1, c+1);  //top right

        minesFound += countMine(r, c-1);    // left
        minesFound += countMine(r, c+1);    // right

        minesFound += countMine(r+1, c-1);  //bottom left
        minesFound += countMine(r+1, c);    //bottom 
        minesFound += countMine(r+1, c+1);  //bottom right

        //if there are any mine founded
        if(minesFound > 0){
            tile.setText(Integer.toString(minesFound));
        }else{
            tile.setText(" ");

            //top 3
            CheckMine(r-1, c-1);    //top left
            CheckMine(r-1, c);      //top 
            CheckMine(r-1, c+1);    //top right

            //left and right
            CheckMine(r, c-1);  //left
            CheckMine(r, c+1);  //right

            //bottom 3 
            CheckMine(r+1, c-1);    //bottom left
            CheckMine(r+1, c);      //bottom 
            CheckMine(r+1, c+1);    //bottom right
        }

        if (tilesClicked == numRows * numCols - mineList.size()) {
            gameOver = true;
            stopTimer();
            textLabel.setText("YOU WIN!");
        }
    }

    // How many Mines are in neighbors
    int countMine(int r, int c){
        if(r < 0 || r >= numRows || c < 0 || c >= numCols ){
            return 0;
        }
        if(mineList.contains(board[r][c])){
            return 1; 
        }
        return 0;
    }


}*/



import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Minesweeper {

    int tileSize = 70;
    int numRows = 8; 
    int numCols = numRows;
    int boardWidth = numCols * tileSize; 
    int boardHeight = numRows * tileSize;

    int mineCount = 8;
    Random randoom = new Random();

    MineTile[][] board;
    ArrayList<MineTile> mineList;
    int tilesClicked = 0; //click all tiles except the one containing mines
    boolean gameOver = false;
    boolean gameStarted = false;

    // Timer related variables
    Timer timer;
    int elapsedSeconds = 0;

    //create the window
    JFrame frame = new JFrame("Minesweeper");
    JLabel textLabel = new JLabel();
    JLabel timerLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    //create Buttons
    private class MineTile extends JButton {
        int r;
        int c;

        public MineTile(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    // Constructor
    public Minesweeper(){
        showSettingsDialog();
    }

    // Method to show settings dialog
    void showSettingsDialog() {
        JDialog settingsDialog = new JDialog(frame, "Settings", true);
        settingsDialog.setLayout(new GridLayout(5, 1));
        
        JLabel rowsLabel = new JLabel("Rows:");
        JTextField rowsField = new JTextField("");
        JLabel colsLabel = new JLabel("Columns:");
        JTextField colsField = new JTextField("");
        
        JButton playButton = new JButton("Play");
        
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numRows = Integer.parseInt(rowsField.getText());
                numCols = Integer.parseInt(colsField.getText());
                boardWidth = numCols * tileSize;
                boardHeight = numRows * tileSize;
                settingsDialog.dispose();
                initializeGame();
            }
        });
        
        settingsDialog.add(rowsLabel);
        settingsDialog.add(rowsField);
        settingsDialog.add(colsLabel);
        settingsDialog.add(colsField);
        settingsDialog.add(new JLabel());
        settingsDialog.add(playButton);
        
        settingsDialog.pack();
        settingsDialog.setSize(new Dimension(250, 200)); 
        settingsDialog.setLocationRelativeTo(null);
        settingsDialog.setVisible(true);
    }

    // Method to initialize the game
    void initializeGame() {
        frame.setSize(boardWidth, boardHeight + 100); // Adjusted height for timer
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setFont(new Font("Arial", Font.BOLD, 25));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Minesweeper");
        
        timerLabel.setFont(new Font("Arial", Font.BOLD, 25));
        timerLabel.setHorizontalAlignment(JLabel.CENTER);
        timerLabel.setText("Time: 0s");

        textPanel.setOpaque(true);
        textPanel.setLayout(new GridLayout(2, 1));
        textPanel.add(textLabel);
        textPanel.add(timerLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(numRows, numCols));
        frame.add(boardPanel);

        board = new MineTile[numRows][numCols];

        for(int r = 0; r < numRows; r++){
            for (int c = 0; c < numCols; c++){
                MineTile tile = new MineTile(r, c);
                board[r][c] = tile;

                tile.setFocusable(false);
                tile.setMargin(new Insets(0, 0, 0, 0));
                tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));

                tile.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e){
                        if (gameOver) {
                            return;
                        }

                        if (!gameStarted) {
                            startTimer();
                            gameStarted = true;
                        }

                        MineTile tile  = (MineTile) e.getSource();

                        //left Click
                        if(e.getButton() == MouseEvent.BUTTON1){
                            if(tile.getText().equals("")){
                                if(mineList.contains(tile)){
                                    revealMines();
                                }else{
                                    CheckMine(tile.r, tile.c);
                                }
                            }
                        }
                        //right click
                        else if(e.getButton() == MouseEvent.BUTTON3){
                            if(tile.getText().equals("")){
                                tile.setText("🚩");
                            }
                            else if(tile.getText().equals("🚩")){
                                tile.setText("");
                            }
                        }
                    }
                });
                boardPanel.add(tile);
            }
        }

        setMine();

        // Timer setup
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedSeconds++;
                timerLabel.setText("Time: " + elapsedSeconds + "s");
            }
        });

        //after the load of all component we set visibility true otherwise the component will be loaded randomly(same will be missing)
        frame.setVisible(true);
    }

    // Start the timer
    void startTimer() {
        elapsedSeconds = 0;
        timer.start();
    }

    // Stop the timer
    void stopTimer() {
        timer.stop();
    }

    // Mine function
    void setMine(){
        mineList = new ArrayList<MineTile>();
        int mineLeft = mineCount;
        while (mineLeft > 0) {
            int r = randoom.nextInt(numRows); // 0 -7 
            int c = randoom.nextInt(numCols); // 0 -7 

            MineTile tile = board[r][c];

            if (!mineList.contains(tile)) {
                mineList.add(tile);
                mineLeft -= 1;
            }
        }
    }

    // Function to show the bomb when user click on it
    void revealMines(){
        for(int i = 0; i < mineList.size(); i++){
            MineTile tile = mineList.get(i);
            tile.setText("💣");
        }

        gameOver = true;
        stopTimer();
        textLabel.setText("GAME OVER!");
    }

    // Check if there are Mines in neighbors
    void CheckMine(int r, int c){
        if(r < 0 || r >= numRows || c < 0 || c >= numCols ){
            return;
        }

        MineTile tile = board[r][c];
        if (!tile.isEnabled()) {
            return;
        }

        tile.setEnabled(false);
        tilesClicked += 1;
        int minesFound = 0;

        minesFound += countMine(r-1, c-1);  //top left
        minesFound += countMine(r-1, c);    // top
        minesFound += countMine(r-1, c+1);  //top right

        minesFound += countMine(r, c-1);    // left
        minesFound += countMine(r, c+1);    // right

        minesFound += countMine(r+1, c-1);  //bottom left
        minesFound += countMine(r+1, c);    //bottom 
        minesFound += countMine(r+1, c+1);  //bottom right

        //if there are any mine founded
        if(minesFound > 0){
            tile.setText(Integer.toString(minesFound));
        }else{
            tile.setText(" ");

            //top 3
            CheckMine(r-1, c-1);    //top left
            CheckMine(r-1, c);      //top 
            CheckMine(r-1, c+1);    //top right

            //left and right
            CheckMine(r, c-1);  //left
            CheckMine(r, c+1);  //right

            //bottom 3 
            CheckMine(r+1, c-1);    //bottom left
            CheckMine(r+1, c);      //bottom 
            CheckMine(r+1, c+1);    //bottom right
        }

        if (tilesClicked == numRows * numCols - mineList.size()) {
            gameOver = true;
            stopTimer();
            textLabel.setText("YOU WIN!");
        }
    }

    // How many Mines are in neighbors
    int countMine(int r, int c){
        if(r < 0 || r >= numRows || c < 0 || c >= numCols ){
            return 0;
        }
        if(mineList.contains(board[r][c])){
            return 1; 
        }
        return 0;
    }

    public static void main(String[] args) {
        new Minesweeper();
    }
}
