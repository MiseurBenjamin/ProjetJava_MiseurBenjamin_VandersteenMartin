package Game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import LevelEditor.level;

/**
 * PanneauJeu est la classe qui s'occupe de l'affichage de l'écran de jeu.
 * Elle reçoit les inputs claviers de déplaçement et de tir et les exécutes.
 * Elle utilie un Timer pour effectuer le rafraichissement de l'affichage, les vérifications de collisions et les mouvements à
 * une fréquence de 40Hz.
 * 
 * @author Arkentias
 *
 */

@SuppressWarnings("serial")
public class PanneauJeu extends JPanel implements KeyListener, ActionListener{
	level niveau = new level(); //La carte du niveau
	private final Timer timer = new Timer(25,this); //Le timer à 40Hz
	static private ArrayList<Block> blocks = new ArrayList<Block>(); //Les blocs et leurs coordonnées
	static private ArrayList<Fond> fonds = new ArrayList<Fond>(); //Les blocs de fond
	static private ArrayList<Shot> shots = new ArrayList<Shot>(); //Les tirs en cours de déplacement
	Player CurrentPlayer; //Le joueur actuel, sera utilisé comme pointeur lors de l'ajout du multijoueur en LAN
	Player player1,player2; //Les 2 personnages et leurs coordonnées, images et points de vie
	int p1Points,p2Points=0; //Variables contenant les points accumulés par chacun des joueurs
    Block block; //Variable tampon 
    Fond fond; //variable tampon
    Shot shot; //variable tampon
	
	public PanneauJeu(){
		setFocusable(true);
		addKeyListener(this); //Ajout d'un KeyListener sur tout le panel
		initArrayList(); //Initialisation des ArrayLists en fonction de level.txt et création des joueurs
	}
	
	
	/**
	 * initArrayList() initalises les ArrayLists de blocs et fond en fonction du fichier level.txt et crée 2 variables de type Player
	 * pour représenter les 2 joueurs dans le jeu.
	 */
	public void initArrayList(){
		int stop1=0,stop2=0,i,j;
		int lvlCopy[][] = niveau.getLvl(); //Le tableau à deux dimensions de int symbolisant la carte de jeu 
											//( 0 = bloc de fond, 1 = blocs de pierre )
		
		for(i=0;i<20;i++){					//On itère tout le tableau pour créer tous les "Block" et les "Fond" représentant la carte dans le jeu
			for(j=0;j<15;j++){
				if(lvlCopy[i][j]==1){
					block = new Block(i*34,j*34);
					blocks.add(block);				//Ajout des Blocks à l'ArrayList "blocks"
				}
				else{
					fond = new Fond(i*34,j*34);
					fonds.add(fond);				//Ajout des Fonds à l'ArrayList "fonds"
				}
			}
		}
		while(stop2==0){							//Création et placement du joueur 2
			for(i=0;i<20;i++){
				for(j=0;j<15;j++){
					if(this.niveau.getLvl()[i][j]==0){
						this.player2 = new Player(i*34,j*34,2);
						stop2=1;
					}
				}
				
			}
		}
		while(stop1==0){
			for(i=19;i>=0;i--){						//Création et placement du joueur 1
				for(j=14;j>=0;j--){
					if(this.niveau.getLvl()[i][j]==0){
						this.player1 = new Player(i*34,j*34,1);
						stop1=1;
					}
				}
				
			}
		}
		player1.setLife(3);				//Initialisation des points de vie des deux joueurs
		player2.setLife(3);
		repaint();						//Rafraichissement de l'affichage avec les objets nouvellement créés
		timer.start();					//Lancement du Timer
	}
	
	/**
	 * La fonction paint, utilisée au travers de repaint(), gère tout l'affichage et la remise à zéro du round quand un joueur n'a plus de pdv.
	 */
	public void paint(Graphics g){ 
		
		Graphics2D g2d = (Graphics2D) g;							//Création d'un objet Graphics2D
		g2d.setFont(new Font("SansSerif", Font.BOLD, 20));			//Mise à jour de la police d'affichage
		for(int i=0;i < blocks.size();i++){							//Afficher tous les blocs en fonction de leurs coordonnées et images
			block = blocks.get(i);												//Prise un à un de tous les blocs dans l'ArrayList et affichage
			g2d.drawImage(block.getImage(),block.getX(),block.getY(),null);		//de ceux-ci
		}
		for(int i=0;i < fonds.size();i++){							//Idem pour les fonds
			fond = fonds.get(i);
			g2d.drawImage(fond.getImage(),fond.getX(),fond.getY(),null);
		}
		for(int i=0;i < shots.size();i++){								//Affichage de tous les tirs en cours de mouvement et gestion de leur déplacements
			shot = shots.get(i);
			shot.Move();												//Mouvement des tirs
			g2d.drawImage(shot.getImage(),shot.getX(),shot.getY(),null);
		}
		
		g2d.drawImage(player1.getImage(),player1.getX(),player1.getY(),null);	//Affichage des deux joueurs
		g2d.drawImage(player2.getImage(),player2.getX(),player2.getY(),null);	
		g.drawString("P1: "+p1Points+" Points",10,500);							//Affichage des points de chaque joueurs
		g.drawString("P2: "+p2Points+" Points",525,500);
		
		
		if(player2.getLife()<=0){												//Vérifie les points de vie du joueur 2, donne un point au joueur 1
			p1Points+=1;														//si nécessaire et démarre un nouveau round
			timer.stop();
			initArrayList();
		}
		if(player1.getLife()<=0){												//Idem pour le joueur 1
			p2Points+=1;
			timer.stop();
			initArrayList();
		}
		
		}
	
	
	/**
	 * Gère tous les inputs clavier de déplacement (Z,Q,S,D = joueur2, haut,bas,gauche,droite = joueur1).
	 * Met à "true" les booléens de déplacement adéquats.
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_DOWN){			//Vérification de l'input pour le player1 et action en conséquence
			player1.setPlayerDir("BAS");		//Direction du joueur changée en "BAS"
			player1.setBas(true);				//Booléen de déplacement mis à true
		}
		else if(key == KeyEvent.VK_UP){
			player1.setPlayerDir("HAUT");
			player1.setHaut(true);
		}
		else if(key == KeyEvent.VK_LEFT){
			player1.setPlayerDir("GAUCHE");
			player1.setGauche(true);
		}
		else if(key == KeyEvent.VK_RIGHT){
			player1.setPlayerDir("DROITE");
			player1.setDroite(true);
		}
		else if(key == KeyEvent.VK_Z){			//Vérification de l'input pour le player2 et action en conséquence
			player2.setPlayerDir("HAUT");		//Direction du joueur changée en "HAUT"
			player2.setHaut(true);				//Booléen de déplacement mis à true
		}
		else if(key == KeyEvent.VK_Q){
			player2.setPlayerDir("GAUCHE");
			player2.setGauche(true);
		}
		else if(key == KeyEvent.VK_S){
			player2.setPlayerDir("BAS");
			player2.setBas(true);
		}
		else if(key == KeyEvent.VK_D){
			player2.setPlayerDir("DROITE");
			player2.setDroite(true);
		}
		
		repaint();								//Actualisation de l'affichage
	}

	
	/**
	 * Gère tous les inputs clavier de tir (SHIFT = joueur2, ESPACE = joueur1).
	 * Met à "false" les booléens de déplacement adéquats.
	 */
		@Override
		public void keyReleased(KeyEvent arg0) {
			int key = arg0.getKeyCode();
			if(key == KeyEvent.VK_SPACE){
				shot = new Shot(player1.getX(),player1.getY(),1,player1.getPlayerDir());	//Ajout d'un shot à l'arraylist pour le joueur 1
				shots.add(shot);
			}	
			else if(key == KeyEvent.VK_SHIFT){
				shot = new Shot(player2.getX(),player2.getY(),2,player2.getPlayerDir());	//Ajout d'un shot à l'arraylist pour le joueur 2
				shots.add(shot);
			}	
			else if(key == KeyEvent.VK_DOWN){		//Booléens de déplacements du joueur1 mis à false
				player1.setPlayerDir("BAS");
				player1.setBas(false);
			}
			else if(key == KeyEvent.VK_UP){
				player1.setPlayerDir("HAUT");
				player1.setHaut(false);
			}
			else if(key == KeyEvent.VK_LEFT){
				player1.setPlayerDir("GAUCHE");
				player1.setGauche(false);
			}
			else if(key == KeyEvent.VK_RIGHT){
				player1.setPlayerDir("DROITE");
				player1.setDroite(false);
			}
			else if(key == KeyEvent.VK_Z){			//Booléens de déplacements du joueur2 mis à false
				player2.setPlayerDir("HAUT");
				player2.setHaut(false);
			}
			else if(key == KeyEvent.VK_Q){
				player2.setPlayerDir("GAUCHE");
				player2.setGauche(false);
			}
			else if(key == KeyEvent.VK_S){
				player2.setPlayerDir("BAS");
				player2.setBas(false);
			}
			else if(key == KeyEvent.VK_D){
				player2.setPlayerDir("DROITE");
				player2.setDroite(false);
			}
		}
	
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		
		/**
		 * Gestion de toutes les collisions et des sorties de map
		 */
		public void CheckCollision(){
			Rectangle player1Rec,player2Rec;
			
			player1Rec = player1.getBounds();					//On enregistre le rectangle de "hitbox" de chaque joueur dans une variable
			player2Rec = player2.getBounds();
			
			for(int i = 0;i < blocks.size();i++){					//Vérification de la collision de chaque joueur avec tous les Blocks
				block = (Block)blocks.get(i);
				Rectangle BlockRec = block.getBounds();
				if(player1Rec.intersects(BlockRec)){
					String PlayerDir = player1.getPlayerDir();		//Mouvement opposé en cas de collision
					if( PlayerDir=="BAS") player1.addY(-4);
					if( PlayerDir=="HAUT") player1.addY(+4);
					if( PlayerDir=="GAUCHE") player1.addX(+4);
					if( PlayerDir=="DROITE") player1.addX(-4);					
				}
				if(player2Rec.intersects(BlockRec)){
					String PlayerDir = player2.getPlayerDir();
					if( PlayerDir=="BAS") player2.addY(-4);
					if( PlayerDir=="HAUT") player2.addY(+4);
					if( PlayerDir=="GAUCHE") player2.addX(+4);
					if( PlayerDir=="DROITE") player2.addX(-4);					
				}
				for(int j = 0;j < shots.size();j++){				//Vérification de collision entre les Blocks et les Shots
					shot = shots.get(j);
					Rectangle ShotRec = shot.getBounds();
					if(BlockRec.intersects(ShotRec)) shots.remove(j);	//Suppression du shot de l'ArrayList s'il y a collision		
				}
			}
			for(int j = 0;j < shots.size();j++){					//On itère toute l'ArrayList de shot pour vérifier les collisions avec
				shot = shots.get(j);								//les joueurs en ne retirant de la vie que si le tir ne vient pas du joueur
				Rectangle ShotRec = shot.getBounds();				//lui même.
				int num = shot.getNum();
				if(num==1){
					if(ShotRec.intersects(player2Rec)){
						player2.addLife(-1);						//Retrait de vie
						shots.remove(j);							//Suppression du tir de l'ArrayList
					}
				}
				else if(num==2){
					if(ShotRec.intersects(player1Rec)){
						player1.addLife(-1);
						shots.remove(j);
					}
				}
			}
			
			if(player1Rec.intersects(player2Rec)){					//Collisions entre joueurs, peut-être à retirer?
				String PlayerDir = player1.getPlayerDir();
				if( PlayerDir=="BAS") player1.addY(-4);				//Mouvement du joueurs 1 dans le sens opposé à la collisions
				if( PlayerDir=="HAUT") player1.addY(+4);			//à changer : Vérifier les booléens de déplaçements pour  savoir
				if( PlayerDir=="GAUCHE") player1.addX(+4);			//quel joueur doit être déplaçé.
				if( PlayerDir=="DROITE") player1.addX(-4);					
			}
			if((player1.getY()>535)||(player1.getY()<0)) initArrayList();		//Vérification des sorties de map et reset en conséquence
			if((player1.getX()>685)||(player1.getX()<0)) initArrayList();
			if((player2.getY()>535)||(player2.getY()<0)) initArrayList();
			if((player2.getX()>685)||(player2.getY()<0)) initArrayList();
		}

/**
 * Actions effectuées par le Timer toutes les 0,025 secondes
 * 
 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			player1.Move();					//Mouvemements des deux joueurs (Vérif. des booléens de déplacement et mouvement si nécessaire)
			player2.Move();
			repaint();						//Actualisation de l'affichage
			CheckCollision();				//Vérification des collisions
		}
	}
