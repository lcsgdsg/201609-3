import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Role{
    int life,power;
    Role(int life,int power){this.life = life;this.power=power;}
    Role(int life){this.life=life;}
}

public class Game{
    static List<Role> []p = new ArrayList[2];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < p.length; i++) {
            p[i] = new ArrayList<Role>();
            p[i].add(new Role(30,0));
        }
        int player = 0;
        int pos=0,attack=0,health=0;
        int attacker=0,defender=0;

        while((n--)!=0){
            String action = sc.next();
            if(action.equals("summon")){
                pos = sc.nextInt();
                attack = sc.nextInt();
                health = sc.nextInt();
                p[player].add(pos, new Role(health,attack));
            }
            else if(action.equals("attack")){
                attacker = sc.nextInt();
                defender = sc.nextInt();


                p[player].get(attacker).life -= p[1-player].get(defender).power;
                p[1-player].get(defender).life -= p[player].get(attacker).power;

                if(p[player].get(attacker).life <= 0){
                    p[player].remove(attacker);
                }
                if(defender!=0 && p[1-player].get(defender).life <= 0){
                    p[1-player].remove(defender);
                }

            }
            else if(action.equals("end")){
                player = 1-player;
            }else{
                System.out.println("error");
            }
        }

        if(p[0].get(0).life <=0 ) {
            System.out.println(-1);
        }
        else if(p[1].get(0).life <=0) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }

        System.out.println(p[0].get(0).life);

        System.out.print(p[0].size()-1+" ");
        for (int i = 1; i < p[0].size(); i++) {
            System.out.print(p[0].get(i).life+" ");
        }
        System.out.println();

        System.out.println(p[1].get(0).life);

        System.out.print(p[1].size()-1+" ");
        for (int i = 1; i < p[1].size(); i++) {
            System.out.print(p[1].get(i).life+" ");
        }
    }
}