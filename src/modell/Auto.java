package modell;


/* SPECIFIK�CI�:
Ha egy aut�val megy�nk, akkor elfogy az �zemanyag. 
Ha tankoltunk, akkor �jra tudunk menni, lesz �zemanyag.
Csak akkor tudunk menni, ha be van ind�tva az aut�.
Csak akkor tudunk tankolni, ha le van �ll�tva az aut�.
TODO:
Van p�tker�k, kaphatunk defektet, lehet kereket cser�lni:
 - Meg lehet adni a p�tkerekek sz�m�t (lehet 0 is), ha nem adjuk meg, akkor 1.
 - Ha megy az aut� 20% es�llyel kaphat defektet!
 - Ha defektet kapott, nem fogy el az �zemanyag!
 - Nem csak defektes kereket cser�lhet�nk!
 - Ha lecser�lt�k a defektes kereket, cs�kken a p�tkerekek sz�ma!
 - Ha nincs t�bb p�tker�k, nem tudunk cser�lni t�bbet! 
 - Defekttel nem haladhatunk!
//// specifik�ci� v�ge */

public class Auto {
    /* ADATTAGOK */
    private static int objektumDb = 0; //oszt�ly adattagja, lehet itt inicializ�lni
    
    /* objektum adattagokat a konstruktor inicializ�l: */
    private boolean uzemanyag; //p�ld�ny v. m�sn�ven az objektum adattagja
    private boolean beinditva; //p�ld�ny v. m�sn�ven az objektum adattagja

    private boolean defekt;
    private int potkerek;
    
    /* TAGF�GGV�NYEK */
    /* kstr h�v�si l�nc: t�lterhelt kstr h�vja a m�sik kstr-t */
    public Auto(){
        /* semmi nem lehet a kstr. h�v�s el�tt, mert nem fordul le! */
        //int i = 7;
        
        /* kstr csak kstr-b�l h�vunk, this kulcssz�val, nem a nev�vel */
        this(true, false);
    }
    
    public Auto(boolean beinditva){
        this(false, beinditva);
    }
    
    public Auto(boolean uzemanyag, boolean beinditva){
        this(uzemanyag, beinditva, 1);
    }
    
    public Auto(boolean uzemanyag, boolean beinditva, int potkerek){
        Auto.objektumDb++;
        this.uzemanyag = uzemanyag;
        this.beinditva = beinditva;
        this.potkerek = potkerek;
        this.defekt = false;
    }
    
    public void setBeinditva(boolean beinditva){
        /* lehetne tov�bbi ellen�rz�s, pl.:
        csak akkor lehet beind�tani, ha van �zemanyag
        */
        this.beinditva = beinditva;
    }
    
     public void megyEselyDefektre(){
        megyEselyDefektre(.2);
    }
    
    public void megyEselyDefektre(double esely){
        if (beinditva && uzemanyag && !defekt) {
            if(Math.random() < esely){
                defektetKap();
            }else{
                megy();
            }
        }
    }
    
    //setUzemanyag(false)
    public void megy(){
        if (beinditva && uzemanyag && !defekt) {
           this.uzemanyag = false;
        }
    }
    
    //setUzemanyag(true)
    public void tankol(){
        if (!beinditva) {
            this.uzemanyag = true;
        }
    }
    
    public void kerekCsere(){
        if (defekt && potkerek > 0) {
            this.defekt = false;
            potkerek--;
        }
    }
    
    public void defektetKap(){
        this.defekt = true;
    }

    public boolean isUzemanyag() {
        return uzemanyag;
    }

    public boolean isDefekt() {
        return defekt;
    }

    public int getPotkerek() {
        return potkerek;
    }


    public boolean isBeinditva() {
        return beinditva;
    }

}

