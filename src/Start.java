public class Start {
	public final static int
		OPTION1_NEW_HARDCORE = 0,
		OPTION1_LOAD_HARDCORE = 1,
		OPTION1_PICK_GAME = 2,
		OPTION1_QUIT = 3,
		OPTION_NEW_GAME = 0,
		OPTION_JOURNEY = 1,
		OPTION_QUIT = 2;

	public static void main(String [] args){
		switch (mainMenu()){
			case OPTION1_NEW_HARDCORE:
				newHardCore();
			break;
			case OPTION1_NEW_HARDCORE:
				loadHardCore();
			break;
			case OPTION1_PICK_GAME:
				pickGame();
			break;
			case OPTION1_QUIT:
				exit();
			break;
		}
	}

	private void newHardCore(){
		Player p = createU1Player();
		World w = loadWorld("u1sorsar.wor");
		saveHardCore(p, w);
		Game g = new Game (w, p);
		g.setsubGame(Game.U1);
		p.setPosition(50,50);
		p.setHardCore(true);
		g.run();
	}

	private void loadHardCore(){
		HardCoreAdvance advance = loadHardCoreAdvance();
		World w = advance.currentWorld;
		Player p = advance.player;
		Game g = new Game (w, p);
		g.setsubGame(advance.currentGame);
		p.setHardCore(true);
		g.run();
	}

	private void pickGame(){
		newNormal(pick());
	}

	private void newNormal(int game){
		Player p = null;
		World w = null;
		Game g = null;
		switch (game){
			case 1:
				p = createU1Player();
				w = loadWorld("u1sorsar.wor");
				g = new World(w,p);
				g.setsubGame(Game.U1);
				p.setPosition(50,50);
			break;
			case 2:
				p = createU2Player();
				w = loadWorld("u2sorsar.wor");
				g = new World(w,p);
				g.setsubGame(Game.U2);
				p.setPosition(50,50);
			break;
			case 3:
				p = createU3Player();
				w = loadWorld("u3sorsar.wor");
				g = new World(w,p);
				g.setsubGame(Game.U3);
				p.setPosition(50,50);
			break;
		}
		g.run();
	}



}