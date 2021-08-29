
package CalcNutri1;

import java.util.Scanner;
public class ImcGebVet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite 1 se você é homem e 2 se você é mulher: ");
        int sexo = input.nextInt();
        
        System.out.println("Qual sua classificação: \n"
                + "Digite 1 para sedentário,\n"
                + "2 para leve,\n"
                + "3 para moderado e \n"
                + "4 para intenso.");
        int ativ = input.nextInt();
        
        System.out.println("Digite sua idade: ");
        int idade = input.nextInt();
        
        System.out.println("Digite sua altura e peso: ");
        float x = input.nextFloat();
        float y = input.nextFloat();
       
        float c = IMC(x, y);
        double h = GEBH(idade, x, y);
        double m = GEBM(idade, x, y);
        double fa = AtividadeH(ativ, h);
        double Fa = AtividadeH(ativ, m);
        double Pi = PI(x);
        imprime(c);
        imprimePi(Pi);
        
       if(sexo == 1){
            imprimeH(h);
            imprime1(fa);
       }else if(sexo == 2){
           imprimeM(m);
           imprime2(Fa);
       }
       
    }
    static void imprime(float imc){
        System.err.printf("Seu IMC é: %.2f %n", imc);
    }
    static void imprimeH(double gebh){
        System.err.printf("Seu GEB masculino no método da OMS é: %.2f %n", gebh);
    }
   static void imprimeM(double gebm){
        System.err.printf("Seu GEB feminino no método da OMS é: %.2f %n", gebm);
    }
   static void imprime1(double FA){
        System.err.printf("Seu fator de atividade masculino é: %.2f %n", FA);
    }
   static void imprime2(double Fa){
        System.err.printf("Seu fator de atividade feminino é: %.2f %n", Fa);
    }
   static void imprimePi(double pi){
        System.err.printf("Seu peso ideial é: %.2fkg %n", pi);
    }
   
    
    public static float IMC(float alt, float peso){
      float imc = peso / (alt*alt);
       return imc;
    }
    
    public static double GEBH(int idade, float alt, float peso){
        double gebh = 0;
        if(idade >= 10 && idade <= 18){
            gebh = ((16.6*peso)+(77*alt)+572);
        }
        else if(idade > 18 && idade < 30){
            gebh = ((15.4*peso)+(27*alt)+717);
        }
        else if(idade >= 30 && idade < 60){
            gebh = ((11.3*peso)+(16*alt)+901);
        }
        else if(idade >= 60){
            gebh = ((8.8*peso)+(1128*alt)-1071);
        }
        return gebh;
    }
    
    public static double GEBM(int idade, float alt, float peso){
        double gebm = 0;
        if(idade >= 10 && idade <= 18){
            gebm = ((7.4*peso)+(482*alt)+217);
        }
        else if(idade > 18 && idade < 30){
            gebm = ((13.3*peso)+(334*alt)+35);
        }
        else if(idade >= 30 && idade < 60){
            gebm = ((8.7*peso)+(25*alt)+865);
        }
        else if(idade >= 60){
            gebm = ((9.2*peso)+(637*alt)-302);
        }
        return gebm;
    }
    
   public static double AtividadeH(int ativ, double gebh){
     double FA = 0;
       if(ativ == 1){
          FA = (gebh*1.40);
      }
       else if(ativ == 2){
           FA = (gebh*1.55);
       }
       else if(ativ == 3){
           FA = (gebh*1.78);
       }
       else if(ativ == 4){
           FA = (ativ*2.10);
       }
       return FA;
   }
    
   public static double AtividadeM(int ativ, double gebm){
     double Fa = 0;
       if(ativ == 1){
          Fa = (gebm*1.40);
      }
       else if(ativ == 2){
           Fa = (gebm*1.55);
       }
       else if(ativ == 3){
           Fa = (gebm*1.78);
       }
       else if(ativ == 4){
           Fa = (ativ*2.10);
       }
       return Fa;
   }
   
   public static double PI(float alt){
       double pi;
       pi = (alt*alt) * 21.7;
       return pi;
   }
}


