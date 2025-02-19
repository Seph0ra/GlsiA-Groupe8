package GlsiAGroupe8.GestionStock.service;

import GlsiAGroupe8.GestionStock.models.Produit;
import GlsiAGroupe8.GestionStock.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    //Enregistrer un produit dans la base
    public void saveProduit(Produit produit)
    {
        produitRepository.save(produit);
    }

    //Afficher les produits
    public List<Produit> showAllProduit()
    {
        return produitRepository.findAll();
    }

    //selectionner un seul produit
    public Produit selectedProduit(int id)
    {
        Optional<Produit> optional = produitRepository.findById(id);
        Produit produit = null;
        if(optional.isPresent())
        {
            produit = optional.get();
        }else
        {
            throw new RuntimeException("id introuvable");
        }
        return  produit;
    }

    //supprimer un produit
    public void deleteProduit(int id){
        if (selectedProduit(id) != null) {
            produitRepository.deleteById(id);
        }
    }

}
