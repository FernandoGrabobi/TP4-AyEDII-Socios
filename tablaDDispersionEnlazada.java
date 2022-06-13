package ejercicio12punto7;


public class tablaDDispersionEnlazada {

    static final double CONST = 0.618034;
    static final int TAMANTABLA = 97;
    public int numElement;
    private Elemento [] tabla;

    static int dispersion(long x){
        double t;
        int v;
        t = CONST * x - Math.floor(CONST*x);
        v = (int)(TAMANTABLA * t);
        return v; 
    }

    public tablaDDispersionEnlazada(){
        tabla = new Elemento[TAMANTABLA];
        for(int k = 0; k < TAMANTABLA; k++){
            tabla[k]=null;
            numElement = 0;
        }
    }

    public void insertar(tipoSocio s){
        int posicion;
        Elemento nuevo;
        posicion = dispersion(s.getCodigo());
        nuevo = new Elemento(s);
        nuevo.sgte = tabla[posicion];
        tabla[posicion] = nuevo;
        numElement++;
    }

    public void eliminar(int keyCode){

        int posicion;
        posicion = dispersion(keyCode);

        if(tabla[posicion] != null){

            Elemento anterior, actual;
            anterior = null;
            actual = tabla[posicion];

            while ((actual.sgte != null)&& actual.getSocio().getCodigo() != keyCode) {
                anterior = actual;
                actual = actual.sgte;
            }

            if (actual.getSocio().getCodigo() != keyCode) {
                System.out.println("\n no se encuentra en la tabla de socios "+keyCode);
            }else{
                if (anterior == null) {
                    tabla[posicion] = actual.sgte;
                }else{
                    anterior.sgte = actual.sgte;
                }
                actual = null;
                numElement--;
            }
        }
    }

    public Elemento buscar(int keyCode){
        Elemento p = null;
        int posicion;
        posicion = dispersion(keyCode);
        if (tabla[posicion] != null) {
            p = tabla[posicion];
            while((p.sgte != null)&& p.socio.codigo != keyCode){
                p = p.sgte;
            }
            if(p.socio.codigo != keyCode){
                p = null;
            }
        }
        return p;
    }
}
