import java.util.Collections;
import java.util.List;

public class polje {
    
    public Integer getKenta(List<Integer> l, Integer i){
        if(l.contains(1) == true && l.contains(2) && l.contains(3) && l.contains(4) && l.contains(5)){
            if(i == 1){
                return 66;
            }
            else if(i == 2){
                return 56;
            }
            else{
                return 46;
            }
        }
        else if(l.contains(6) && l.contains(2) && l.contains(3) && l.contains(4) && l.contains(5)){
            if(i == 1){
                return 66;
            }
            else if(i == 2){
                return 56;
            }
            else{
                return 46;
            }
        }
        else{
            return 0;
        }

    }

    public Integer getFull(List<Integer> l){
        if(Collections.frequency(l, 6) >= 3){
            if(Collections.frequency(l, 5) >=2){
                return 58;
            }
            else if(Collections.frequency(l, 4) >=2){
                return 56;
            }
            else if(Collections.frequency(l, 3) >= 2){
                return 54;
            }
            else if(Collections.frequency(l, 2) >= 2){
                return 52;
            }
            else if(Collections.frequency(l, 1) >= 2){
                return 50;
            }
            else{
                return 0;
            }
        }
        else if(Collections.frequency(l, 5) >= 3){
            if(Collections.frequency(l, 6) >= 2){
                return 57;
            }
            else if(Collections.frequency(l, 4) >=2){
                return 53;
            }
            else if(Collections.frequency(l, 3) >= 2){
                return 51;
            }
            else if(Collections.frequency(l, 2) >= 2){
                return 49;
            }
            else if(Collections.frequency(l, 1) >= 2){
                return 47;
            }
            else{
                return 0;
            }
        }
        else if(Collections.frequency(l, 4) >= 3){
            if(Collections.frequency(l, 6) >= 2){
                return 54;
            }
            else if(Collections.frequency(l, 5) >=2){
                return 52;
            }
            else if(Collections.frequency(l, 3) >= 2){
                return 48;
            }
            else if(Collections.frequency(l, 2) >= 2){
                return 46;
            }
            else if(Collections.frequency(l, 1) >= 2){
                return 44;
            }
            else{
                return 0;
            }
        }
        else if(Collections.frequency(l, 3) >= 3){
            if(Collections.frequency(l, 6) >= 2){
                return 51;
            }
            else if(Collections.frequency(l, 5) >=2){
                return 49;
            }
            else if(Collections.frequency(l, 4) >= 2){
                return 47;
            }
            else if(Collections.frequency(l, 2) >= 2){
                return 43;
            }
            else if(Collections.frequency(l, 1) >= 2){
                return 41;
            }
            else{
                return 0;
            }
        }
        else if(Collections.frequency(l, 2) >= 3){
            if(Collections.frequency(l, 6) >= 2){
                return 48;
            }
            else if(Collections.frequency(l, 5) >=2){
                return 46;
            }
            else if(Collections.frequency(l, 4) >= 2){
                return 44;
            }
            else if(Collections.frequency(l, 3) >= 2){
                return 42;
            }
            else if(Collections.frequency(l, 1) >= 2){
                return 38;
            }
            else{
                return 0;
            }
        }
        else if(Collections.frequency(l, 1) >= 3){
            if(Collections.frequency(l, 6) >= 2){
                return 45;
            }
            else if(Collections.frequency(l, 5) >=2){
                return 43;
            }
            else if(Collections.frequency(l, 4) >= 2){
                return 41;
            }
            else if(Collections.frequency(l, 3) >= 2){
                return 39;
            }
            else if(Collections.frequency(l, 2) >= 2){
                return 37;
            }
            else{
                return 0;
            }
        }
        else{
            return 0;
        }
    }

    public Integer getPoker(List<Integer> l){
        if(Collections.frequency(l, 1) >= 4){
            return 44;
        }
        else if(Collections.frequency(l, 2) >= 4){
            return 48;
        }
        else if(Collections.frequency(l, 3) >= 4){
            return 52;
        }
        else if(Collections.frequency(l, 4) >= 4){
            return 56;
        }
        else if(Collections.frequency(l, 5) >= 4){
            return 60;
        }
        else if(Collections.frequency(l, 6) >= 4){
            return 64;
        }
        else{
            return 0;
        }
    }

    public Integer getYamb(List<Integer> l){
        if(Collections.frequency(l, 1) >= 5){
            return 55;
        }
        else if(Collections.frequency(l, 2) >= 5){
            return 60;
        }
        else if(Collections.frequency(l, 3) >= 5){
            return 65;
        }
        else if(Collections.frequency(l, 4) >= 5){
            return 70;
        }
        else if(Collections.frequency(l, 5) >= 5){
            return 75;
        }
        else if(Collections.frequency(l, 6) >= 5){
            return 80;
        }
        else{
            return 0;
        }
    }
}
