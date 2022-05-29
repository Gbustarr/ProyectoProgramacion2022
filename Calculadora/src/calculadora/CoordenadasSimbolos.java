/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author oknmi
 */
public class CoordenadasSimbolos {

    double[] cero(double x, double y) {
        double[] cero = {x - 10, y - 40, x, y - 40,
            x, y - 40, x, y - 10,
            x, y - 10, x - 10, y - 10,
            x - 10, y - 10, x - 10, y - 40
        };
        return cero;
    }

    double[] ceroPot(double x, double y) {
        double[] cero = {x - 10, y - 40, x - 5, y - 40,
            x - 5, y - 40, x - 5, y - 25,
            x - 5, y - 25, x - 10, y - 25,
            x - 10, y - 25, x - 10, y - 40
        };
        return cero;
    }

    double[] uno(double x, double y) {
        double[] uno = {x - 10, y - 35, x - 5, y - 40,
            x - 5, y - 40, x - 5, y - 10,
            x - 10, y - 10, x, y - 10};
        return uno;
    }

    double[] unoPot(double x, double y) {
        double[] uno = {x - 10, y - 32.5, x - 7.5, y - 40, x - 7.5, y - 40, x - 7.5, y - 25};
        return uno;
    }

    double[] dos(double x, double y) {
        double[] dos = {x - 10, y - 40, x, y - 40,
            x, y - 40, x, y - 25,
            x, y - 25, x - 10, y - 25,
            x - 10, y - 25, x - 10, y - 10,
            x - 10, y - 10, x, y - 10};
        return dos;
    }

    double[] dosPot(double x, double y) {
        double[] dos = {x - 10, y - 40, x - 5, y - 40, x - 5, y - 40, x - 5, y - 32.5, x - 5, y - 32.5, x - 10, y - 32.5, x - 10, y - 32.5, x - 10, y - 25, x - 10, y - 25, x - 5, y - 25};
        return dos;
    }

    double[] tres(double x, double y) {
        double[] tres = {x - 10, y - 40, x, y - 40,
            x, y - 40, x, y - 25,
            x, y - 25, x - 10, y - 25,
            x, y - 25, x, y - 10,
            x - 10, y - 10, x, y - 10};
        return tres;
    }

    double[] tresPot(double x, double y) {
        double[] tres = {x - 10, y - 40, x - 5, y - 40, x - 5, y - 40, x - 5, y - 25, x - 5, y - 25, x - 10, y - 25, x - 5, y - 32.5, x - 10, y - 32.5};
        return tres;
    }

    double[] cuatro(double x, double y) {
        double[] cuatro = {x - 10, y - 40, x - 10, y - 25,
            x - 10, y - 25, x, y - 25,
            x, y - 40, x, y - 10};
        return cuatro;
    }

    double[] cuatroPot(double x, double y) {
        double[] cuatro = {x - 10, y - 40, x - 10, y - 32.5, x - 10, y - 32.5, x - 5, y - 32.5, x - 5, y - 40, x - 5, y - 25};
        return cuatro;
    }

    double[] cinco(double x, double y) {
        double[] cinco = {x - 10, y - 40, x, y - 40,
            x - 10, y - 40, x - 10, y - 25,
            x - 10, y - 25, x, y - 25,
            x, y - 25, x, y - 10,
            x, y - 10, x - 10, y - 10};

        return cinco;
    }

    double[] cincoPot(double x, double y) {
        double[] cinco = {x - 5, y - 40, x - 10, y - 40, x - 10, y - 40, x - 10, y - 32.5, x - 10, y - 32.5, x - 5, y - 32.5, x - 5, y - 32.5, x - 5, y - 25, x - 5, y - 25, x - 10, y - 25};

        return cinco;
    }

    double[] seis(double x, double y) {
        double[] seis = {x - 10, y - 40, x, y - 40,
            x - 10, y - 40, x - 10, y - 10,
            x - 10, y - 10, x, y - 10,
            x, y - 10, x, y - 25,
            x, y - 25, x - 10, y - 25};
        return seis;
    }

    double[] seisPot(double x, double y) {
        double[] seis = {x - 5, y - 40, x - 10, y - 40, x - 10, y - 40, x - 10, y - 25, x - 10, y - 25, x - 5, y - 25, x - 5, y - 25, x - 5, y - 32.5, x - 5, y - 32.5, x - 10, y - 32.5};
        return seis;
    }

    double[] siete(double x, double y) {
        double[] siete = {x - 10, y - 40, x, y - 40,
            x, y - 40, x, y - 10};
        return siete;
    }

    double[] sietePot(double x, double y) {
        double[] siete = {x - 10, y - 40, x - 5, y - 40, x - 5, y - 40, x - 5, y - 25};
        return siete;
    }

    double[] ocho(double x, double y) {
        double[] ocho = {x - 10, y - 40, x, y - 40,
            x - 10, y - 40, x - 10, y - 10,
            x - 10, y - 10, x, y - 10,
            x, y - 10, x, y - 40,
            x - 10, y - 25, x, y - 25};
        return ocho;
    }

    double[] ochoPot(double x, double y) {
        double[] ocho = {x - 10, y - 40, x - 5, y - 40, x - 5, y - 40, x - 5, y - 25, x - 5, y - 25, x - 10, y - 25, x - 5, y - 32.5, x - 10, y - 32.5, x - 10, y - 40, x - 10, y - 25};
        return ocho;
    }

    double[] nueve(double x, double y) {
        double[] nueve = {x - 10, y - 40, x, y - 40,
            x - 10, y - 40, x - 10, y - 25,
            x - 10, y - 25, x, y - 25,
            x, y - 40, x, y - 10
        };
        return nueve;
    }

    double[] nuevePot(double x, double y) {
        double[] nueve = {x - 5, y - 32.5, x - 10, y - 32.5, x - 10, y - 32.5, x - 10, y - 40, x - 10, y - 40, x - 5, y - 40, x - 5, y - 40, x - 5, y - 25};
        return nueve;
    }

    double[] mas(double x, double y) {
        double[] mas = {x - 5, y - 32.5, x - 5, y - 17.5,
            x - 10, y - 25, x, y - 25};
        return mas;
    }

    double[] masPot(double x, double y) {
        double[] mas = {x - 7.5, y - 36.25, x - 7.5, y - 28.75,
            x - 10, y - 32.5, x - 5, y - 32.5};
        return mas;
    }

    double[] menos(double x, double y) {
        double[] menos = {x - 10, y - 25, x, y - 25};
        return menos;
    }

    double[] menosPot(double x, double y) {
        double[] menos = {x - 10, y - 32.5, x - 5, y - 32.5};
        return menos;
    }

    double[] multiplicar(double x, double y) {
        double[] multiplicar = {x - 10, y - 32.5, x, y - 17.5,
            x - 10, y - 17.5, x, y - 32.5
        };
        return multiplicar;
    }

    double[] multiplicarPot(double x, double y) {
        double[] multiplicar = {x - 10, y - 36.25, x - 5, y - 28.75,
            x - 5, y - 36.25, x - 10, y - 28.75
        };
        return multiplicar;
    }

    double[] dividir(double x, double y) {

        double[] dividir = {x - 10, y - 25, x, y - 25};
        return dividir;
    }

    double[] factorial(double x, double y) {
        double[] factorial = {x - 7, y - 40, x - 7, y - 18,
            x - 7, y - 10, x - 7, y - 10,
            x - 7, y - 10, x - 7, y - 10,
            x - 7, y - 10, x - 7, y - 10};
        return factorial;
    }

    double[] s(double x, double y) {
        double[] s = {x, y - 35, x, y - 40, x, y - 40, x - 10, y - 40,
            x - 10, y - 40, x - 10, y - 30, x - 10, y - 30, x, y - 30,
            x, y - 30, x, y - 10, x, y - 10, x - 10, y - 10,
            x - 10, y - 10, x - 10, y - 15};
        return s;
    }

    double[] sPot(double x, double y) {
        double[] s_p = {x - 5, y - 40, x - 10, y - 40, x - 10, y - 40, x - 10, y - 32.5, x - 10, y - 32.5, x - 5, y - 32.5, x - 5, y - 32.5, x - 5, y - 25, x - 5, y - 25, x - 10, y - 25};
        return s_p;
    }

    double[] i(double x, double y) {
        double[] i = {x - 5, y - 10, x - 5, y - 35,
            x - 5, y - 40, x - 5, y - 40,
            x - 5, y - 40, x - 5, y - 40};
        return i;
    }

    double[] iPot(double x, double y) {
        double[] i_p
            = {x - 7.5, y - 40, x - 7.5, y - 40,
                x - 7.5, y - 36, x - 7.5, y - 25};
        return i_p;
    }

    double[] n(double x, double y) {
        double[] n = {x - 10, y - 10, x - 10, y - 40,
            x - 10, y - 40, x, y - 10, x, y - 10,
            x, y - 40};
        return n;
    }

    double[] nPot(double x, double y) {
        double[] n_p = {x-10,y-25,x-10,y-40,
                     x-10,y-40,x-5,y-25,
                     x-5,y-25, x-5,y-40};
        return n_p;
    }

    double[] c(double x, double y) {
        double[] c = {x, y - 35, x, y - 40,
            x, y - 40, x - 5, y - 40,
            x - 5, y - 40, x - 10, y - 32.5,
            x - 10, y - 32.5, x - 10, y - 17.5,
            x - 10, y - 17.5, x - 5, y - 10,
            x - 5, y - 10, x, y - 10,
            x, y - 10, x, y - 15};
        return c;
    }

    double[] cPot(double x, double y) {
        double[] c_p = {x - 6, y - 40, x-10, y - 40,
            x-10, y - 40, x - 10, y - 25,
            x - 10, y - 25, x - 6, y - 25
        };
        return c_p;
    }

    double[] o(double x, double y) {
        double[] o = {x - 7.5, y - 10, x - 10, y - 17.5,
            x - 10, y - 17.5, x - 10, y - 32.5,
            x - 10, y - 32.5, x - 7.5, y - 40,
            x - 7.5, y - 40, x - 2.5, y - 40,
            x - 2.5, y - 40, x, y - 32.5,
            x, y - 32.5, x, y - 17.5,
            x, y - 17.5, x - 2.5, y - 10,
            x - 2.5, y - 10, x - 7.5, y - 10,};
        return o;
    }

    double[] oPot(double x, double y) {
        double[] o_p = {x - 10, y - 40, x-10, y - 25,
            x-10, y - 25, x-5, y - 25,
            x-5, y - 25, x - 5, y - 40,
            x - 5, y - 40, x - 10, y - 40
        };
        return o_p;
    }

    double[] t(double x, double y) {
        double[] t = {x - 5, y - 10, x - 5, y - 40,
            x - 5, y - 40, x, y - 40, x, y - 40, x - 10, y - 40};
        return t;
    }

    double[] tPot(double x, double y) {
        double[] t_p = {x-5,y-40,x-5,y-25,
                         x-8,y-40,x-2,y-40};
        return t_p;
    }

    double[] a(double x, double y) {
        double[] a = {x - 10, y - 10, x - 10, y - 32.5,
            x - 10, y - 32.5, x - 7.5, y - 40,
            x - 7.5, y - 40, x - 2.5, y - 40,
            x - 2.5, y - 40, x, y - 32.5,
            x, y - 32.5, x, y - 10,
            x, y - 10, x, y - 25,
            x, y - 25, x - 10, y - 25};
        return a;
    }

    double[] aPot(double x, double y) {
        double[] a_p = {x-10,y-25,x-10,y-32.5,
                        x-10,y-32.5,x-8.75,y-40,
                        x-8.75,y-40,x-6.25,y-40,
                        x-6.25,y-40,x-5,y-32.5,
                        x-5,y-32.5,x-5,y-25,
                        x-5,y-25,x-5,y-32.5,
                        x-5,y-32.5,x-10,y-32.
        };
        return a_p;
    }

    double[] pAbierto(double x, double y) {
        double[] pAbierto = {x - 3, y - 40,
            x - 7, y - 32.5,
            x - 7, y - 32.5,
            x - 7, y - 17.5,
            x - 7, y - 17.5,
            x - 3, y - 10
        };
        return pAbierto;
    }

    double[] pAbiertoPot(double x, double y) {
        double[] pAbierto = {x - 7.5, y - 40,
            x - 10, y - 36.5,
            x - 10, y - 36.5,
            x - 10, y - 28.75,
            x - 10, y - 28.75,
            x - 7.5, y - 25
        };
        return pAbierto;
    }

    double[] pCerrado(double x, double y) {
        double[] pCerrado = {x - 7, y - 40,
            x - 3, y - 32.5,
            x - 3, y - 32.5,
            x - 3, y - 17.5,
            x - 3, y - 17.5,
            x - 7, y - 10
        };
        return pCerrado;
    }

    double[] pCerradoPot(double x, double y) {
        double[] pCerrado = {x - 7.5, y - 40,
            x - 5, y - 36.5,
            x - 5, y - 36.5,
            x - 5, y - 28.75,
            x - 5, y - 28.75,
            x - 7.5, y - 25
        };
        return pCerrado;
    }

    double[] grado(double x, double y) {
        double[] grado = {x - 10, y - 40, x, y - 40,
            x, y - 40, x, y - 25,
            x, y - 25, x - 10, y - 25,
            x - 10, y - 25, x - 10, y - 40
        };

        return grado;
    }

    double[] gradoPot(double x, double y) {
        double[] grado = {x - 10, y - 40, x - 5, y - 40,
            x - 5, y - 40, x - 5, y - 32.5,
            x - 5, y - 32.5, x - 10, y - 32.5,
            x - 10, y - 32.5, x - 10, y - 40
        };

        return grado;
    }

}
