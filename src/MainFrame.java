import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtTicTacToe;
	private JTextField WinnerText;
	private String winner; 
	private Integer count = 0; 
	private Boolean game = true; 
	private static String[][] board = new String[3][3]; 

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//this honestly took me way too long to figure out and i don't wanna talk about it
	

	public void checking() {
		//check for winner
		if(count > 3 && count < 8) {

			if(board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != null) { //top row 
				if(count % 2 == 0) {
					winner = "Player 1 Wins";
					WinnerText.setText(winner);
				} else {
					winner = "Player 2 Wins";
					WinnerText.setText(winner);
				}
			} else if (board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][0] != null) { //middle row 
				if(count % 2 == 0) {
					winner = "Player 1 Wins";
					WinnerText.setText(winner);
				} else {
					winner = "Player 2 Wins";
					WinnerText.setText(winner);
				}
			} else if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] != null) { //bottom row 
				if(count % 2 == 0) {
					winner = "Player 1 Wins";
					WinnerText.setText(winner);
				} else {
					winner = "Player 2 Wins";
					WinnerText.setText(winner);
				}
			} else if (board[0][0] == board[1][0] && board[0][0] == board[2][0] && board[0][0] != null) { //left column
				if(count % 2 == 0) {
					winner = "Player 1 Wins";
					WinnerText.setText(winner);
				} else {
					winner = "Player 2 Wins";
					WinnerText.setText(winner);
				}
			}  else if (board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[0][1] != null) { //middle column
				if(count % 2 == 0) {
					winner = "Player 1 Wins";
					WinnerText.setText(winner);
				} else {
					winner = "Player 2 Wins";
					WinnerText.setText(winner);
				}
			}  else if (board[0][2] == board[1][2] && board[0][2] == board[2][2] && board[0][2] != null) { //right column
				if(count % 2 == 0) {
					winner = "Player 1 Wins";
					WinnerText.setText(winner);
				} else {
					winner = "Player 2 Wins";
					WinnerText.setText(winner);
				}
			} else if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != null) { //top left to bottom right diagonal
				if(count % 2 == 0) {
					winner = "Player 1 Wins";
					WinnerText.setText(winner);
				} else {
					winner = "Player 2 Wins";
					WinnerText.setText(winner);
				}
			} else if(board[2][0] == board[1][1] && board[2][0] == board[0][2] && board[2][0] != null) { //top right to bottom left diagonal
				if(count % 2 == 0) {
					winner = "Player 1 Wins";
					WinnerText.setText(winner);
				} else {
					winner = "Player 2 Wins";
					WinnerText.setText(winner);
				}
			}
		} else if (count == 8) {
			winner = "Draw";
			WinnerText.setText(winner);
		}
		
		if(winner != null) {
			game = false; 
		}
		
		count++; 
		System.out.println(count);
	}
	
	public MainFrame() {
		setTitle("TIC TAC TOE");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 579);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtTicTacToe = new JTextField();
		txtTicTacToe.setHorizontalAlignment(SwingConstants.CENTER);
		txtTicTacToe.setBackground(new Color(143, 188, 143));
		txtTicTacToe.setForeground(	SystemColor.info);
		txtTicTacToe.setText("TIC TAC TOE");
		txtTicTacToe.setEditable(false);
		txtTicTacToe.setFont(new Font("Arial", Font.BOLD, 44));
		txtTicTacToe.setBounds(141, 11, 283, 80);
		contentPane.add(txtTicTacToe);
		txtTicTacToe.setColumns(10);
		
		WinnerText = new JTextField();
		WinnerText.setForeground(UIManager.getColor("Table.focusCellForeground"));
		WinnerText.setBackground(new Color(255, 228, 196));
		WinnerText.setEditable(false);
		WinnerText.setHorizontalAlignment(SwingConstants.CENTER);
		WinnerText.setFont(new Font("Arial", Font.BOLD, 17));
		WinnerText.setBounds(209, 102, 138, 48);
		contentPane.add(WinnerText);
		WinnerText.setColumns(10);
		
		JButton topLeftBtn = new JButton("");
		topLeftBtn.setForeground(Color.DARK_GRAY);
		topLeftBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//add it to the array 
				if(game) {
					if(count % 2 == 0) {
						board[0][0] = "X";
						topLeftBtn.setText("X");
					} else {
						board[0][0] = "O";
						topLeftBtn.setText("O");
					}
					
					checking();
				}
			}
		});
		topLeftBtn.setFont(new Font("Arial", Font.PLAIN, 60));
		topLeftBtn.setBounds(74, 176, 89, 80);
		contentPane.add(topLeftBtn);
		
		JButton topMiddleBtn = new JButton("");
		topMiddleBtn.setForeground(Color.DARK_GRAY);
		topMiddleBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//add it to the array 
				if(game) {
					if(count % 2 == 0) {
						board[0][1] = "X";
						topMiddleBtn.setText("X");
					} else {
						board[0][1] = "O";
						topMiddleBtn.setText("O");
					}
					
					checking();
				}
			}
		});
		topMiddleBtn.setFont(new Font("Arial", Font.PLAIN, 60));
		topMiddleBtn.setBounds(233, 176, 89, 80);
		contentPane.add(topMiddleBtn);
		
		JButton topRightBtn = new JButton("");
		topRightBtn.setForeground(Color.DARK_GRAY);
		topRightBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//add it to the array 
				if(game) {
					if(count % 2 == 0) {
						board[0][2] = "X";
						topRightBtn.setText("X");
					} else {
						board[0][2] = "O";
						topRightBtn.setText("O");
					}
					
					checking();
				}
			}
		});
		topRightBtn.setFont(new Font("Arial", Font.PLAIN, 60));
		topRightBtn.setBounds(394, 176, 89, 80);
		contentPane.add(topRightBtn);
		
		JButton middleLeftBtn = new JButton("");
		middleLeftBtn.setForeground(Color.DARK_GRAY);
		middleLeftBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//add it to the array 
				if(game) {
					if(count % 2 == 0) {
						board[1][0] = "X";
						middleLeftBtn.setText("X");
					} else {
						board[1][0] = "O";
						middleLeftBtn.setText("O");
					}
					
					checking();
				}
			}
		});
		middleLeftBtn.setFont(new Font("Arial", Font.PLAIN, 60));
		middleLeftBtn.setBounds(74, 291, 89, 80);
		contentPane.add(middleLeftBtn);
		
		JButton middleMiddleBtn = new JButton("");
		middleMiddleBtn.setForeground(Color.DARK_GRAY);
		middleMiddleBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//add it to the array 
				if(game) {
					if(count % 2 == 0) {
						board[1][1] = "X";
						middleMiddleBtn.setText("X");
					} else {
						board[1][1] = "O";
						middleMiddleBtn.setText("O");
					}
					
					checking();
				}
			}
		});
		middleMiddleBtn.setFont(new Font("Arial", Font.PLAIN, 60));
		middleMiddleBtn.setBounds(233, 291, 89, 80);
		contentPane.add(middleMiddleBtn);
		
		JButton middleRightBtn = new JButton("");
		middleRightBtn.setForeground(Color.DARK_GRAY);
		middleRightBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//add it to the array 
				if(game) {
					if(count % 2 == 0) {
						board[1][2] = "X";
						middleRightBtn.setText("X");
					} else {
						board[1][2] = "O";
						middleRightBtn.setText("O");
					}
					
					checking();
				}
			}
		});
		middleRightBtn.setFont(new Font("Arial", Font.PLAIN, 60));
		middleRightBtn.setBounds(394, 291, 89, 80);
		contentPane.add(middleRightBtn);
		
		JButton bottomLeftBtn = new JButton("");
		bottomLeftBtn.setForeground(Color.DARK_GRAY);
		bottomLeftBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//add it to the array 
				if(game) {
					if(count % 2 == 0) {
						board[2][0] = "X";
						bottomLeftBtn.setText("X");
					} else {
						board[2][0] = "O";
						bottomLeftBtn.setText("O");
					}
					
					checking();
				}
			}
		});
		bottomLeftBtn.setFont(new Font("Arial", Font.PLAIN, 60));
		bottomLeftBtn.setBounds(74, 407, 89, 80);
		contentPane.add(bottomLeftBtn);
		
		JButton bottomMiddleBtn = new JButton("");
		bottomMiddleBtn.setForeground(Color.DARK_GRAY);
		bottomMiddleBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//add it to the array 
				if(game) {
					if(count % 2 == 0) {
						board[2][1] = "X";
						bottomMiddleBtn.setText("X");
					} else {
						board[2][1] = "O";
						bottomMiddleBtn.setText("O");
					}
					
					checking();
				}
			}
		});
		bottomMiddleBtn.setFont(new Font("Arial", Font.PLAIN, 60));
		bottomMiddleBtn.setBounds(233, 407, 89, 80);
		contentPane.add(bottomMiddleBtn);
		
		JButton bottomRightBtn = new JButton("");
		bottomRightBtn.setForeground(Color.DARK_GRAY);
		bottomRightBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//add it to the array 
				if(game) {
					if(count % 2 == 0) {
						board[2][2] = "X";
						bottomRightBtn.setText("X");
					} else {
						board[2][2] = "O";
						bottomRightBtn.setText("O");
					}
					
					checking();
				}
			}
		});
		bottomRightBtn.setFont(new Font("Arial", Font.PLAIN, 60));
		bottomRightBtn.setBounds(394, 407, 89, 80);
		contentPane.add(bottomRightBtn);
	}

}