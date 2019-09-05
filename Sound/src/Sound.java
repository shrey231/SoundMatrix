import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.applet.*;
import java.net.*;
import java.util.ArrayList;
public class Sound extends JFrame implements Runnable,ActionListener
{
	int cols=30;
	JToggleButton button[][]=new JToggleButton[39][cols];
	Thread timing;
	JPanel panel=new JPanel();
	AudioClip soundClip[]=new AudioClip[39];
	boolean notStopped=true;
	JFrame frame=new JFrame();
	JMenuBar bar;
	JMenu song;
	JMenu col;
	JMenu user;
	JMenuItem song1;
	JMenuItem song2;
	JMenuItem song3;
	JMenuItem add;
	JMenuItem remove;
	JButton clear;
	JButton rand;
	JButton pauseplay;
	boolean pp = false;
	ArrayList<String[][]> songs;
	JButton save;
	ArrayList<JMenuItem> mlist;
	String[] arrCol;
	String[][] listSongs;
	//int d = 200;
	int change = 200;
	int interval = change;

	DefaultBoundedRangeModel range = new DefaultBoundedRangeModel(200, 0, 1, 200);
	JSlider slide = new JSlider(range);


	public Sound()
	{
		
		bar = new JMenuBar();
		song = new JMenu("Pre-built songs");
		col = new JMenu("Add/Remove Columns");
		user = new JMenu("User Songs");
		
		add = new JMenuItem("Add Column");
		remove = new JMenuItem("Remove Column");
		
		clear = new JButton("Clear");
		rand = new JButton("Randomize");
		save = new JButton("Save");
		pauseplay = new JButton("Pause/Play");
		
		
		add.addActionListener(this);
		remove.addActionListener(this);
		clear.addActionListener(this);
		rand.addActionListener(this);
		save.addActionListener(this);
		pauseplay.addActionListener(this);
		
		
		
		col.add(add);
		col.add(remove);
		
		bar.add(song);
		bar.add(col);
		bar.add(user);
		bar.add(clear);
		bar.add(rand);
		bar.add(save);
		bar.add(pauseplay);
		bar.add(slide);
		
		mlist = new ArrayList<JMenuItem>();
		songs = new ArrayList<String[][]>();
		frame.add(bar,BorderLayout.NORTH);

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,1000);
		
		for(int y=0;y<cols;y++){
			for(int x=0;x<39;x++)
			{
				button[x][y]=new JToggleButton();
				button[x][y].addActionListener(this);
				panel.add(button[x][y]);
			}
		}
		
		for(int j=0;j<cols;j++){
			button[0][j].setText("E6");
			button[1][j].setText("D6");
			button[2][j].setText("C6");
			button[3][j].setText("B5");
			button[4][j].setText("ASharp5");
			button[5][j].setText("A5");
			button[6][j].setText("GSharp5");
			button[7][j].setText("G5");
			button[8][j].setText("FSharp5");
			button[9][j].setText("F5");
			button[10][j].setText("E5");
			button[11][j].setText("DSharp5");
			button[12][j].setText("D5");
			button[13][j].setText("CSharp5");
			button[14][j].setText("C5");
			button[15][j].setText("B4");
			button[16][j].setText("ASharp4");
			button[17][j].setText("A4");
			button[18][j].setText("GSharp4");
			button[19][j].setText("G4");
			button[20][j].setText("FSharp4");
			button[21][j].setText("F4");
			button[22][j].setText("E4");
			button[23][j].setText("DSharp4");
			button[24][j].setText("D4");
			button[25][j].setText("CSharp4");
			button[26][j].setText("C4");
			button[27][j].setText("B3");
			button[28][j].setText("ASharp3");
			button[29][j].setText("A3");
			button[30][j].setText("GSharp3");
			button[31][j].setText("G3");
			button[32][j].setText("FSharp3");
			button[33][j].setText("F3");
			button[34][j].setText("E3");
			button[35][j].setText("DSharp3");
			button[36][j].setText("D3");
			button[37][j].setText("CSharp3");
			button[38][j].setText("C3");
		}
	
		slide.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
               change = ((JSlider)e.getSource()).getValue();
            }
        });

		
		noteReader("FurElise");
		noteReader("Ode");
		noteReader("Gospel");
		try
		{
			URL test = new URL("file:A3.wav");
			URL a3 = new URL("file:A3.wav");
			URL b3 = new URL("file:B3.wav");
			URL c3 = new URL("file:C3.wav");
			URL d3 = new URL("file:D3.wav");
			URL e3 = new URL("file:E3.wav");
			URL f3 = new URL("file:F3.wav");
			URL g3 = new URL("file:G3.wav");
			URL asharp3 = new URL("file:ASharp3.wav");
			URL csharp3 = new URL("file:CSharp3.wav");
			URL dsharp3 = new URL("file:DSharp3.wav");
			URL fsharp3 = new URL("file:FSharp3.wav");
			URL gsharp3 = new URL("file:GSharp3.wav");

			URL a4 = new URL("file:A4.wav");
			URL b4 = new URL("file:B4.wav");
			URL c4 = new URL("file:C4.wav");
			URL d4 = new URL("file:D4.wav");
			URL e4 = new URL("file:E4.wav");
			URL f4 = new URL("file:F4.wav");
			URL g4 = new URL("file:G4.wav");

			URL asharp4 = new URL("file:ASharp4.wav");
			URL csharp4 = new URL("file:CSharp4.wav");
			URL dsharp4 = new URL("file:DSharp4.wav");
			URL fsharp4 = new URL("file:FSharp4.wav");
			URL gsharp4 = new URL("file:GSharp4.wav");

			URL a5 = new URL("file:A5.wav");
			URL b5 = new URL("file:B5.wav");
			URL c5 = new URL("file:C5.wav");
			URL d5 = new URL("file:D5.wav");
			URL e5 = new URL("file:E5.wav");
			URL f5 = new URL("file:F5.wav");
			URL g5 = new URL("file:G5.wav");

			URL asharp5 = new URL("file:ASharp5.wav");
			URL csharp5 = new URL("file:CSharp5.wav");
			URL dsharp5 = new URL("file:DSharp5.wav");
			URL fsharp5 = new URL("file:FSharp5.wav");
			URL gsharp5 = new URL("file:GSharp5.wav");

			URL c6 = new URL("file:C6.wav");
			URL d6 = new URL("file:D6.wav");
			URL e6 = new URL("file:E6.wav");

			soundClip[0] = JApplet.newAudioClip(e6);
			soundClip[1] = JApplet.newAudioClip(d6);
			soundClip[2] = JApplet.newAudioClip(c6);
			soundClip[3] = JApplet.newAudioClip(b5);
			soundClip[4] = JApplet.newAudioClip(asharp5);
			soundClip[5] = JApplet.newAudioClip(a5);
			soundClip[6] = JApplet.newAudioClip(gsharp5);
			soundClip[7] = JApplet.newAudioClip(g5);
			soundClip[8] = JApplet.newAudioClip(fsharp5);
			soundClip[9] = JApplet.newAudioClip(f5);
			soundClip[10] = JApplet.newAudioClip(e5);
			soundClip[11] = JApplet.newAudioClip(dsharp5);
			soundClip[12] = JApplet.newAudioClip(d5);
			soundClip[13] = JApplet.newAudioClip(csharp5);
			soundClip[14] = JApplet.newAudioClip(c5);
			soundClip[15] = JApplet.newAudioClip(b4);
			soundClip[16] = JApplet.newAudioClip(asharp4);
			soundClip[17] = JApplet.newAudioClip(a4);
			soundClip[18] = JApplet.newAudioClip(gsharp4);
			soundClip[19] = JApplet.newAudioClip(g4);
			soundClip[20] = JApplet.newAudioClip(fsharp4);
			soundClip[21] = JApplet.newAudioClip(f4);
			soundClip[22] = JApplet.newAudioClip(e4);
			soundClip[23] = JApplet.newAudioClip(dsharp4);
			soundClip[24] = JApplet.newAudioClip(d4);
			soundClip[25] = JApplet.newAudioClip(csharp4);
			soundClip[26] = JApplet.newAudioClip(c4);
			soundClip[27] = JApplet.newAudioClip(b3);
			soundClip[28] = JApplet.newAudioClip(asharp3);
			soundClip[29] = JApplet.newAudioClip(a3);
			soundClip[30] = JApplet.newAudioClip(gsharp3);
			soundClip[31] = JApplet.newAudioClip(g3);
			soundClip[32] = JApplet.newAudioClip(fsharp3);
			soundClip[33] = JApplet.newAudioClip(f3);
			soundClip[34] = JApplet.newAudioClip(e3);
			soundClip[35] = JApplet.newAudioClip(dsharp3);
			soundClip[36] = JApplet.newAudioClip(d3);
			soundClip[37] = JApplet.newAudioClip(csharp3);
			soundClip[38] = JApplet.newAudioClip(c3);
		
			frame.revalidate();
			
		}catch(MalformedURLException mue)
		{
			System.out.println("File not found");
		}
		
		createMatrix();
		frame.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread timing = new Thread(this);
		timing.start();
		
		/*panel.setLayout(new GridLayout(6,6,1,1)); //the last two numbers "space out" the buttons
		for(int x=0;x<6;x++)
		for(int y=0;y<6;y++)
		{

			button[x][y]=new JToggleButton();
			panel.add(button[x][y]);
		}
		this.add(panel);
		setSize(1000,1000);
		//setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel,BorderLayout.CENTER);
		frame.setVisible(true);
		Thread timing = new Thread(this);
		timing.start();*/
	}
	
	public void createMatrix(){
		panel.removeAll();
		panel.setLayout(new GridLayout(39,cols,1,4)); 
		
		JToggleButton[][] tem = button.clone();

		button=new JToggleButton[39][cols];
		
		for(int y=0;y<cols;y++){
			if(y<tem[0].length){
				for(int x=0;x<39;x++){
					button[x][y]=tem[x][y];
				}
			}
			else
			for(int x=0;x<39;x++){
				button[x][y]=new JToggleButton();
				button[x][y].addActionListener(this);
			}
		}
		for(int i=0;i<39;i++){
		for(int j=0;j<cols;j++){
			panel.add(button[i][j]);
		}
		System.out.println();
	}
		for(int i=0;i<cols;i++)
			for(int j=0;j<39;j++){
				if(!button[j][i].isSelected())
				{
					button[j][i].setBorder(new LineBorder(Color.BLACK));
					button[j][i].setForeground(Color.BLACK);
				}
				button[j][i].setSelected(false);
			}
		frame.setSize(30*cols,1000);
		frame.add(panel);

	}
	public void noteReader(String s){

			File name = new File(s+".txt");
			ArrayList<String[]>temps=new ArrayList<String[]>();
			try
			{
				BufferedReader input = new BufferedReader(new FileReader(name));
				String text;
				while( (text=input.readLine())!= null)
				{
					arrCol=text.split("");
					temps.add(arrCol);
				}
				int rows=temps.size();
				int colu=temps.get(0).length;
				listSongs=new String[rows][colu];
				
				for(int i=0;i<rows;i++){
					for(int j=0;j<colu;j++){
						listSongs[i][j]=temps.get(i)[j];
					}
				}

			}
			catch (IOException io)
			{
				System.err.println("Error");

			}
		
			songs.add(listSongs);
			String x=s;
			JMenuItem temp=new JMenuItem(x);
			temp.addActionListener(this);
			song.add(temp);
			mlist.add(temp);
	}

	public void run()
	{
		do
		{
			try
			{
				for(int c=0;c<cols;c++){
					for(int r=0;r<39;r++){
						if(button[r][c].isSelected())
						{
							button[r][c].setBorder(new LineBorder(Color.BLUE));
							button[r][c].setForeground(Color.BLUE);
							if(pp){
								r--;
								c--;
								break;
							}
						
							soundClip[r].stop();
							soundClip[r].play();
						}else {
							button[r][c].setBorder(new LineBorder(Color.BLACK));
							button[r][c].setForeground(Color.BLACK);
						}
						
						
					}
				timing.sleep(change);
				
			}


			}
			catch(InterruptedException e)
			{
			}
		}while(notStopped);
	}
	
	


	public static void main(String args[])
	{
		Sound app=new Sound();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		change = 200;
		for(int b=0;b<button.length;b++)
			for(int n=0;n<button[0].length;n++)
			if(e.getSource()==button[b][n]){
				soundClip[b].stop();
				soundClip[b].play();
			}
		
		for(int i=0;i<mlist.size();i++){
			if(e.getSource()==mlist.get(i)){

				String[][] b =songs.get(i);
				cols=b[0].length;
				button=new JToggleButton[39][cols];
					
					for(int y=0;y<cols;y++){
						for(int x=0;x<39;x++){
							button[x][y]=new JToggleButton();
							button[x][y].addActionListener(this);
							if(b[x][y].equals("1")){
								button[x][y].setSelected(true);
							}
							else{
								button[x][y].setSelected(false);
						}
						}
					}
					panel.removeAll();
					for(int z=0;z<39;z++)
						for(int j=0;j<cols;j++){
							panel.add(button[z][j]);
					}
					for(int j=0;j<cols;j++){
						button[0][j].setText("E6");
						button[1][j].setText("D6");
						button[2][j].setText("C6");
						button[3][j].setText("B5");
						button[4][j].setText("ASharp5");
						button[5][j].setText("A5");
						button[6][j].setText("GSharp5");
						button[7][j].setText("G5");
						button[8][j].setText("FSharp5");
						button[9][j].setText("F5");
						button[10][j].setText("E5");
						button[11][j].setText("DSharp5");
						button[12][j].setText("D5");
						button[13][j].setText("CSharp5");
						button[14][j].setText("C5");
						button[15][j].setText("B4");
						button[16][j].setText("ASharp4");
						button[17][j].setText("A4");
						button[18][j].setText("GSharp4");
						button[19][j].setText("G4");
						button[20][j].setText("FSharp4");
						button[21][j].setText("F4");
						button[22][j].setText("E4");
						button[23][j].setText("DSharp4");
						button[24][j].setText("D4");
						button[25][j].setText("CSharp4");
						button[26][j].setText("C4");
						button[27][j].setText("B3");
						button[28][j].setText("ASharp3");
						button[29][j].setText("A3");
						button[30][j].setText("GSharp3");
						button[31][j].setText("G3");
						button[32][j].setText("FSharp3");
						button[33][j].setText("F3");
						button[34][j].setText("E3");
						button[35][j].setText("DSharp3");
						button[36][j].setText("D3");
						button[37][j].setText("CSharp3");
						button[38][j].setText("C3");
					}
					frame.setSize(30*cols,1000);


			}
		}
		
		if(e.getSource()==add){
			cols++;
			createMatrix();
		}
		if(e.getSource()==remove){
			cols--;
			createMatrix();
		}
		
		if(e.getSource()==clear){
			for(int i=0;i<cols;i++)
			for(int j=0;j<39;j++){
				if(button[j][i].isSelected())
				{
					button[j][i].setBorder(new LineBorder(Color.BLACK));
					button[j][i].setForeground(Color.BLACK);
				}
				button[j][i].setSelected(false);
			}
			
			
		}
		if(e.getSource()==rand){
			for(int i=0;i<cols;i++)
				for(int j=0;j<39;j++){
					button[j][i].setSelected(false);
			}

			for(int y=0;y<cols;y++){
				for(int x=0;x<39;x++){
					int rand=(int)(Math.random()*100);
					if(rand>95)
					button[x][y].setSelected(true);
				}
			}
		}
		
		if(e.getSource()==save){
			String[][] tem = new String[39][cols];

			for(int i=0;i<39;i++){
				for(int j=0;j<cols;j++){
					
					if(button[i][j].isSelected()){
						tem[i][j]="1";
					}
					else tem[i][j]="0";
					System.out.print(tem[i][j]);
				}
				System.out.println();
			}
			songs.add(tem);
			String x="Song - "+(songs.size()-3);
			JMenuItem temp=new JMenuItem(x);
			temp.addActionListener(this);
			user.add(temp);
			mlist.add(temp);
		}
		

		if(e.getSource()==pauseplay){
				if(pauseplay.getText()=="Play"){
					pauseplay.setText("Pause");
					pp=false;
				}
				else{
					pauseplay.setText("Play");
					pp=true;
				}
		}
		
	}
}