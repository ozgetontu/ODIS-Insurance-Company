import java.util.Scanner;

public class Rim {

    private int sizeOfRim;

    public Rim()
    {
        this.sizeOfRim=sizeOfRim;
    }

    public int getSizeOfRim() {
        return sizeOfRim;
    }

    public void setSizeOfRim(int sizeOfRim) {
        this.sizeOfRim = sizeOfRim;
    }


    public int getInput() {

        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the Rim's size: ");
        int sizeOfRim = scn.nextInt();
        return sizeOfRim;
    }

    public String toString()
    {
    	return super.toString()
				+ "\nRim=" + sizeOfRim;
    }
}