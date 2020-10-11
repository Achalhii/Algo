class DessinFractale{
    private final Turtle bob;
    
    private final static int LARGEUR = 800;
    private final static int HAUTEUR = 600;
    //taille de la fenetre graphique


	// le main se trouve à la fin du code

	public DessinFractale(){
	bob  = new Turtle();
	Turtle.setCanvasSize(LARGEUR,HAUTEUR);//à appeler APRES création de la tortue
    }

    public DessinFractale(int v){
	//attention, plus v est grand, plus bob va lentement !
	this();
	bob.speed(v);
    }


    public void reset(){
	bob.clear();
	bob.up();
	bob.setPosition(0,0);
	bob.setDirection(90);
	bob.down();
	bob.width(5);
    }

    public void close(){
	bob.exit();
    }



    public void carre(double l){
    	    bob.forward(l);
			bob.left(90);
		if(bob.getX()!=0 && bob.getY()!=0){
			carre(l);
		}
    }

    // Algos Fractales avec l pour la longueur d'un pas et n pour le nombre de récurrence


	public void vonKoch(double l, int n){
		if(n==0){bob.forward(l);}
    	else{
			vonKoch(l/3,n-1);
		bob.left(60);
			vonKoch(l/3,n-1);
		bob.right(120);
			vonKoch(l/3,n-1);
		bob.left(60);
			vonKoch(l/3,n-1);}
	}

	public void arbre(double l, int n){
    	bob.forward(l);
    	double d = bob.getDirection();
    	if(n!=0){
    		bob.left(40);
    		arbre(l/3,n-1);
			bob.left(-40);
			arbre(l/3,n-1);
			bob.left(-40);
			arbre(l/3,n-1);
			bob.left(40);
		}
    	else{
    		double y= bob.getY();
			double x= bob.getX();
    		bob.setPosition(x,y);
		}
    	bob.left(180);
		bob.forward(l);
		bob.setDirection(d);
	}

	public void triforce(double l, int n){
		for (int i = 0; i < 3; i++) {
			bob.forward(l);
			bob.left(120);
		}
		double d = bob.getDirection();
		if(n!=0){
			double x = bob.getX();
			double y = bob.getY();
			triforce(l/2,n-1);
			bob.forward(l/2);
			triforce(l/2,n-1);
			bob.left(60);
			bob.forward(l/2);
			bob.left(60);
			triforce(l/2,n-1);
			bob.backward(l/2);
			bob.setPosition(x,y);
		}
		bob.setDirection(d);
	}

	public void baobab(double l, int n) {
		bob.forward(l);
		double d = bob.getDirection();
		if (n != 0) {
			bob.left(40);
			arbre(l / 3, n - 1);
			bob.left(-40);
			arbre(l / 3, n - 1);
			bob.left(-40);
			arbre(l / 3, n - 1);
			bob.left(40);
		} else {
			double y = bob.getY();
			double x = bob.getX();
			dragon(1, 3, 1);
			bob.setPosition(x, y);
		}
		bob.left(180);
		bob.forward(l);
		bob.setDirection(d);
	}

	public void dragon(double l,int n, int b){
    		if(n == 0) {
				bob.forward(l);
			}
			else{
				dragon(l,n-1,1);
				bob.left(90*b);
				dragon(l,n-1,-1);
			}
	}

    public static void main(String[] args){
		//creation de la tortue avec la vitesse en paramètre où 0 est la vitesse maximale
		// zoom/dezoom à l'aide de la roulette souris, deplacement possible avec le clique gauche souris

	DessinFractale d = new DessinFractale(1);
	d.reset();

	d.dragon(1000,100,1);
    }
}