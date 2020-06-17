package com.velotn.service;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import com.velotn.IService.IService;
import com.velotn.entity.Panier;
import com.velotn.entity.Wishlist;
import com.velotn.utils.DataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WishlistService implements IService<Wishlist> {

    private Connection con;
    private Statement ste;

    public WishlistService(){con = DataBase.getInstance().getConnection();}

    @Override
    public void ajouter(Wishlist wishlist) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `wishlist` (`product_id`,`user_id`) VALUES (?,?);");
        pre.setInt(1,wishlist.getProduct_id());
        pre.setInt(2,wishlist.getUser_id());
        pre.executeUpdate();
    }

    @Override
    public boolean delete(Wishlist wishlist) throws SQLException {
        PreparedStatement pre = con.prepareStatement("DELETE FROM `wishlist` WHERE id = ?");
        pre.setInt(1,wishlist.getId());
        pre.executeUpdate();
        return true;
    }

    @Override
    public boolean update(Wishlist wishlist) throws SQLException {
        return false;
    }

    @Override
    public List<Wishlist> readAll() throws SQLException {
        List<Wishlist> arr = new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs = ste.executeQuery("SELECT * FROM wishlist INNER JOIN produits ON wishlist.product_id = produits.id");
        while(rs.next()){
            int id = rs.getInt("id");
            String nomprod = rs.getString("nomProd");
            double prix = rs.getDouble("prix");
            String url = rs.getString("img_url");

            Wishlist wishlist = new Wishlist(id,nomprod,prix,url);

            arr.add(wishlist);

        }
        return arr;
    }

    @Override
    public Wishlist search(Wishlist wishlist) throws SQLException {
        return null;
    }

    @Override
    public List<Wishlist> sortByPrice() throws SQLException {
        return null;
    }
}
