public class Auto {
    private boolean encendido;
    private Double combustible;
    private Double tanque;
    private Double temperatura;
    private Integer velocidad;
    private boolean electroVentilador;

    public Auto(){
        encendido = false;
    }

    public Auto(Double combustible){
        encendido =false;
        temperatura = 0.00;
        this.tanque = combustible;
    }

    private void activarElectroVentilador(){
        if (this.temperatura >= 95.00){
            electroVentilador = true;
            temperatura = temperatura - 15.00;
        }
    }

    public void acelerar(Integer velocidad){
        if (encendido){
            this.velocidad = velocidad;
            this.temperatura = temperatura + (0.2 * velocidad);
            this.activarElectroVentilador();
        }
    }

    public void enceder(){
        temperatura = temperatura + 70.00;
        combustible = combustible - ((0.001*combustible)/100);
    }

    public void apagar(){
        temperatura = 0.00;
    }

    public void frenar() {
        if (encendido) {
            this.temperatura = temperatura + (0.04 * this.velocidad);
            this.activarElectroVentilador();
        }
    }

    public Double ObtenerTemperatura(){
        return temperatura;
    }

    public String estadoTanqueCombustible(){
        if ((combustible < (tanque*0.15)) && (combustible > (tanque*0.10))){
            return "Próximo a utilizar la reserva de combustible";
        } else if (combustible < (tanque * 0.10)) {
            return "Em reserva de combustible";
            } else { return "El tanque se encuentra a :" + ((combustible * 100) / tanque);}
    }
}
