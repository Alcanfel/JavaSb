package Task20;

public class Car implements Comparable<Car>{
    private String codeCar;
    private Double typeToplivo;
    private Double rashodToplivo;
    private Double dopParameter;
    private String gosNomer;
    private Double probeg;


    public Car(String codeCar, String gosNomer, double probeg, Double typeToplivo, double rashodToplivo){
        this.codeCar = codeCar;
        this.gosNomer = gosNomer;
        this.probeg = probeg;
        this.typeToplivo = typeToplivo;
        this.rashodToplivo = rashodToplivo;
        this.dopParameter = null;
    }
    public Car(String codeCar, String gosNomer,double probeg, Double dopParameter, double typeToplivo, double rashodToplivo){
        this.codeCar = codeCar;
        this.gosNomer = gosNomer;
        this.probeg = probeg;
        this.typeToplivo = typeToplivo;
        this.rashodToplivo = rashodToplivo;
        this.dopParameter = dopParameter;
    }



    @Override
    public String toString() {
        if (this.getDopParameter() != null){
            return
                    "тип=" + codeCar +
                     ", номер='" + gosNomer + '\'' +
                     ", пробег=" + probeg +
                     ", dopParameter=" + dopParameter;


        } else {
            return
                    "тип=" + codeCar +
                            ", номер='" + gosNomer + '\'' +
                            ", пробег=" + probeg;
        }

    }

    public Double getDopParameter() {
        return dopParameter;
    }

    public double getGsm(){
        return (double) (((this.probeg / 100) * this.rashodToplivo) * this.typeToplivo);
    }

    public String getCodeCar(){
        return this.codeCar;
    }

    public Double getProbeg() {
        return probeg;
    }

    @Override
    public int compareTo(Car car) {
        if (car.getCodeCar() == this.getCodeCar()){
            if (!(car.getProbeg() == this.getProbeg())){
                return Double.compare(this.getProbeg(), car.getProbeg());
            }  else return -1;
        } return -1; //CharSequence.compare(this.getCodeCar(), car.getCodeCar());
    }
}
