package Project3.java;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;

import javax.swing.JFrame;

public class WordGUI{
	static JFrame myFrame;
	static Container cPane; //declare container which belongs to myFrame JFrame
	static TextArea aBox, eBox, iBox, oBox, uBox, otherBox; //declare 6 text areas for receiving different words

	public WordGUI(String chosenFile) { //create constructor WordGUI that will display the file chosen by user
		initialize(); 
		readWordsFromFile(chosenFile); //read words from the file user chose
	}
	
	public static void initialize() { //GUI constructed from a JFrame 
		aBox=new TextArea(); //create new text areas for the different words
		eBox=new TextArea(); 
		iBox=new TextArea();
		oBox=new TextArea();
		uBox=new TextArea();
		otherBox=new TextArea(); 
		myFrame=new JFrame();
		myFrame.setSize(400, 400); //set frame size so all boxes fit in it
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame will be exited
		myFrame.setVisible(true);
	}
	
	static TreeMap<Word, Word>treeMap = new TreeMap<Word, Word>(new WordComparator()); //instanciate treemap (to help sort the words alphabetically using Words as keys) with comparator to tell the Treemap how the keys are ordered
	
	public static void readWordsFromFile(String chosenFile) { //read numbers line by line from  user chosen file
		myFrame.setLayout(new GridLayout(2,3)); //divide myFrame into 2 rows and 3 columns so each word can go into its correct box
		cPane = myFrame.getContentPane(); 
		cPane.add(aBox); //adds the aBox text area to the top left content pane of the JFrame, where words starting with a or A will be placed
		cPane.add(eBox); //adds the eBox text area to the next content pane of the JFrame(top middle box), where words starting with e or E will be placed
		cPane.add(iBox); //adds the iBox text area to the content pane of the JFrame(top right box), where words starting with i or I will be placed
		cPane.add(oBox); //adds the oBox text area to the content pane of the JFrame(bottom left box), where words starting with o or O will be placed
		cPane.add(uBox); //adds the uBox text area to the content pane of the JFrame(bottom middle box), where words starting with u or U will be placed
		cPane.add(otherBox); //adds the otherBox text area to the content pane of the JFrame(bottom right box, where the line starting with anything other than a,e,i,o,u will be placed
		TextFileInput in=new TextFileInput(chosenFile); 
		String line=in.readLine(); 
		while (line!=null) { 
			try {
				Word a=new Word(line); //instanciate a new word from that line
				treeMap.put(a, null); //put that word into the tree
			}
			catch (IllegalWordException e) { 
				System.out.println("Invalid word: " + line); //catch the exception and tell user its invalid
			}   
			finally {
				line=in.readLine(); //continue to read next line
			}
		}
		Set set = treeMap.entrySet(); //returns a collection of key/value pairs
		Iterator i = set.iterator(); //create iterator to help print the map iteratively
		Map.Entry<Word, Word> me; //creates key/value pair
		while (i.hasNext()) { //loop until nothing after iterator
			me = (Map.Entry) i.next(); //cast element after iterator as a map entry
			String WordGiven=me.getKey().toString(); //get the key/word of that iterator map entry and convert it to a string so it can be read
		    if (WordGiven.charAt(0)=='a' || WordGiven.charAt(0)=='A') aBox.append(WordGiven+"\n"); //if that words first letter is an A or a append it to aBox area
		    else if (WordGiven.charAt(0)=='e' || WordGiven.charAt(0)=='E') eBox.append(WordGiven+"\n"); //if that words first letter is an E or e append it to eBox area
		    else if (WordGiven.charAt(0)=='i' || WordGiven.charAt(0)=='I') iBox.append(WordGiven+"\n"); //if that words first letter is an I or i append it to iBox area
		    else if (WordGiven.charAt(0)=='o' || WordGiven.charAt(0)=='O') oBox.append(WordGiven+"\n"); //if that words first letter is an O or o append it to oBox area
		    else if (WordGiven.charAt(0)=='u' || WordGiven.charAt(0)=='U') uBox.append(WordGiven+"\n"); //if that words first letter is an U or u append it to uBox area
		    else otherBox.append(WordGiven+"\n");  //if that words first letter isn't an capital or lowercase a,e,i,o, or u append it to otherBox area
		}
		myFrame.setVisible(true); //JFrame made visible since the JFrame was invisible when initialized
	}
}
