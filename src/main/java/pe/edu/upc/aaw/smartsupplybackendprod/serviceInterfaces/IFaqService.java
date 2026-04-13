package pe.edu.upc.aaw.smartsupplybackendprod.serviceInterfaces;

import pe.edu.upc.aaw.smartsupplybackendprod.entities.Faq;

import java.util.List;

public interface IFaqService {

    public List<Faq> list();
    public Faq listId(Long idFaq);
    public void insert(Faq faq);
    public void delete(Long idFaq);


}
