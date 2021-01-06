package app.wena.formulasaprende.GridView_segundoFragment;


public class Spacecraft {
    private int imgFoto;
    private String titulo;

    public Spacecraft(int imgFoto, String titulo) {
        this.imgFoto = imgFoto;
        this.titulo = titulo;
    }

    public int getImgFoto() {
        return imgFoto;
    }

    public String getTitulo() {
        return titulo;
    }
}