import com.sun.nio.sctp.IllegalReceiveException;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BankManagerImpl extends UnicastRemoteObject implements BankManager {
    private final List<Account> accounts;
    protected BankManagerImpl() throws RemoteException {
        accounts = new ArrayList<Account>();
    }

    @Override
    public void creerCompte(String id, double somme) throws RemoteException {
        // Check if account with the same ID already exists
        if (findAccountById(id) != null) {
            throw new IllegalArgumentException("Un Compte avec " + id + " existe déjà.");
        }
        accounts.add(new Account(id, somme));
    }


    @Override
    public void ajouter(String id, double somme) throws RemoteException {
        // permet de créer un compte avec un identifiant et un solde
        Account accountToAdd = findAccountById(id);
        if(accountToAdd != null){
            accountToAdd.deposer(somme);
        }else{
            throw new IllegalReceiveException("Compte avec l'identifiant " + id + " introuvable.");
        }
    }

    @Override
    public void retirer(String id, double somme) throws RemoteException {
        //permet de retirer une somme à un compte existant
        Account accountToRemove = findAccountById(id);
        if(accountToRemove != null){
            accountToRemove.retirer(somme);
        }else{
            throw new IllegalReceiveException("Compte avec l'identifiant " + id + " introuvable.");
        }
    }

    @Override
    public double consulterSolde(String id) throws RemoteException {
        Account AccountToConsult = findAccountById(id);
        if(AccountToConsult != null){
            return AccountToConsult.getSomme();
        }else{
            throw new IllegalReceiveException("Compte avec l'identifiant " + id + " introuvable.");
        }
    }

    @Override
    public void transfererSolde(String id_C, String id_D, double somme) throws RemoteException {
        // permet de transferer une somme d'un compte a un autre
        Account AccA = findAccountById(id_C);
        Account AccB = findAccountById(id_D);
        if(AccA == null ){
            throw new IllegalReceiveException("Premier compte avec l'identifiant " + id_C + " introuvable.");
        }
        else if(AccB == null){
            throw new IllegalReceiveException("Deuxième compte avec l'identifiant " + id_D + " introuvable.");
        }else{
            AccA.retirer(somme);
            AccB.deposer(somme);
        }
    }
    public Account findAccountById(String id){
        for (Account c:accounts){
            if(c.getId().equals(id)){
                return c ;
            }
        }
        return null;
    }
}
