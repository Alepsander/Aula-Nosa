import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name="rios")
public class ListaRios {
    private ArrayList<Rios> listaRios;

    public void setListaRios(ArrayList<Rios> listaRios) {this.listaRios = listaRios;}

    @XmlElement(name="rio")
    public ArrayList<Rios> getListaRios() {return this.listaRios;}

}
