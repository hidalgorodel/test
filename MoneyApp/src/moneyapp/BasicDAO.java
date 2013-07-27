/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moneyapp;

/**
 *
 * @author rodel
 */
public interface BasicDAO {

    public boolean add(Object o);

    public boolean update(Object o);

    public boolean delete(String id);
}
