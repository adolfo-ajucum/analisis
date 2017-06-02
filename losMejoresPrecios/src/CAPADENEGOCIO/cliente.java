package CAPADENEGOCIO;





// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.9FDCBF5D-F158-BA22-58EF-D6812EC0B72F]
// </editor-fold> 
public class cliente {


    private int idclientes;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0B7A47EB-F7AE-6FBC-1A4D-7AB594FF265A]
    // </editor-fold> 
    private String nombre;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4B55FB73-E300-D338-B331-C68B0395E61C]
    // </editor-fold> 
    private String direccion;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C7E22A9B-5E65-FA25-A410-E69D28363A1D]
    // </editor-fold> 
    private String cui;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7B28F8EA-0C14-6EC6-F4D3-9F5190FEF34B]
    // </editor-fold> 
    private String apellido;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2691ACAE-B28F-6D0E-D59C-BAE65E7A6C35]
    // </editor-fold> 
    private String nit;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2C252229-A448-86B1-508B-C04E0EFFFB7D]
    // </editor-fold> 
    public cliente (int clientes, String nombre, String apellido, String direccion, String cui, String nit) {
        this.idclientes = clientes;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.cui = cui;
        this.nit = nit;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.949D3A26-8B64-7E4A-937B-9145A4FDD9E5]
    // </editor-fold> 
    public String getApellido () {
        return apellido;
    }

 

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1BEB63ED-C2BA-1732-C47C-752CDF6B8BE6]
    // </editor-fold> 
    public String getCui () {
        return cui;
    }

  

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.2915B3EC-25A5-0A97-031D-B3201287ABF8]
    // </editor-fold> 
    public String getDireccion () {
        return direccion;
    }


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8EAFD749-BEE9-3EC5-77A3-8FB87BBA5EE9]
    // </editor-fold> 
    public int getIdclientes () {
        return idclientes;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.83A6CE83-0B84-1DD3-8316-59F7E154D276]
    // </editor-fold> 
    public String getNit () {
        return nit;
    }

  

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B47602F5-C647-8F3D-ECFC-E5306053F650]
    // </editor-fold> 
    public String getNombre () {
        return nombre;
    }

}
