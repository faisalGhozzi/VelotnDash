package com.velotn.service;

import com.velotn.entity.Panier;
import com.velotn.IService.IService;
import com.velotn.utils.DataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicePanier implements IService<Panier> {

    private Connection con;
    private Statement ste;

    public ServicePanier() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Panier panier) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT into `panier` (`produit_id`,`qte`,`prix_unitaire`,`prix_total`,`user_id`) VALUES (?,?,?,?,?);");
        pre.setInt(1,panier.getProduit_id());
        pre.setInt(2,panier.getQte());
        pre.setDouble(3,panier.getPrix_unitaire());
        pre.setDouble(4,panier.getQte()*panier.getPrix_unitaire());
        pre.setInt(5,panier.getUser_id());
        pre.executeUpdate();
    }

    @Override
    public boolean delete(Panier panier) throws SQLException {
        PreparedStatement pre = con.prepareStatement("DELETE FROM `panier` WHERE id = ?");
        pre.setInt(1,panier.getId());
        pre.executeUpdate();
        return true;
    }

    @Override
    public boolean update(Panier panier) throws SQLException {
        PreparedStatement pre = con.prepareStatement("UPDATE `panier` SET qte = ?, prix_total = qte*prix_unitaire where id = ?");
        pre.setInt(1,panier.getQte());
        pre.setInt(2,panier.getId());
        pre.executeUpdate();
        return true;
    }

    @Override
    public List readAll() throws SQLException {
        List<Panier> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs = ste.executeQuery("SELECT * FROM panier inner join produits on panier.produit_id = produits.id");
        while(rs.next()){
            int id = rs.getInt("id");
            int produit_id = rs.getInt("produit_id");
            int qte = rs.getInt("qte");
            Double prix_unitaire = rs.getDouble("prix_unitaire");
            Double prix_total = rs.getDouble("prix_total");
            int user_id = rs.getInt("user_id");
            String url = rs.getString("img_url");
            Panier panier = new Panier(id,produit_id,qte,prix_unitaire,prix_total,user_id,url);
            arr.add(panier);
        }
        return arr;
    }

    @Override
    public Panier search(Panier panier) throws SQLException {
        return null;
    }

    @Override
    public List sortByPrice() throws SQLException {
        return null;
    }
}
