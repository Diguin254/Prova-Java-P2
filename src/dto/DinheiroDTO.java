package dto;

import model.Dinheiro;

public class DinheiroDTO {
    
    public DinheiroDTO() {
    }
    
    public String idDinheiro;
    public String valorD;
    
    public Dinheiro builder() {
        Dinheiro d = new Dinheiro();
        d.setId(idDinheiro == null ? 0 : Integer.valueOf(idDinheiro));
        d.setValorEntregado(valorD == null ? 0.0 : Double.valueOf(valorD));
        
        return d;
    }
}
