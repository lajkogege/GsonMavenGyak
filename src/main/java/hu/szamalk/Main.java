package hu.szamalk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

public class Main {

    public static void main(String[] args) {
        Gson gson = new Gson();
        String cim, szerzo;
        cim = "Az idő rövid története";
        szerzo = "Stephen Hawking";
        Konyv konyv = new Konyv(cim, szerzo, 1988, 4500);

        /*1 objektum*/
        /* szerializálás */
        String objToJson = gson.toJson(konyv);
        System.out.println("könyv obj JSON: " + objToJson);

        /* deszerializálás */
        Konyv ujKonyv = gson.fromJson(objToJson, Konyv.class);
        System.out.println("JSON --> obj: " + ujKonyv);

        /* lista */
        List<Konyv> konyvek = new ArrayList<>();
        konyvek.add(konyv);
        konyvek.add(new Konyv("hhh", "hhhh", 1989, 14500));
        konyvek.add(new Konyv("iii", "iiii", 1990, 15500));
        System.out.println("Lista: " + konyvek);

        System.out.println("---------Lista-----------");
        /* szerializálás */
        String listaToJson = gson.toJson(konyvek);
        System.out.println("JSON: " + listaToJson);

        /* deszerializálás */
        Type listaTipus = new TypeToken<List<Konyv>>(){}.getType();
        List<Konyv> ujLista = gson.fromJson(listaToJson, listaTipus);
        System.out.println("Konyv obj:");
        for (Konyv k : ujLista) {
            System.out.println(k);
        }
    }

    private static class Konyv {
        private String szerzo, cim;
        private int kiadasEve;
        private double ar;

        public Konyv(String cim, String szerzo, int kiadasEve, double ar) {
            this.szerzo = szerzo;
            this.cim = cim;
            this.kiadasEve = kiadasEve;
            this.ar = ar;
        }

        public String getSzerzo() {
            return szerzo;
        }

        public String getCim() {
            return cim;
        }

        public int getKiadasEve() {
            return kiadasEve;
        }

        public double getAr() {
            return ar;
        }

        @Override
        public String toString() {
            return "Konyv{" +
                    "szerzo='" + szerzo + '\'' +
                    ", cim='" + cim + '\'' +
                    ", kiadasEve=" + kiadasEve +
                    ", ar=" + ar +
                    '}';
        }
    }
}
