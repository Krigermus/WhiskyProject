package facades;

import entities.Whisky;
import entities.dto.WhiskyDTO;
import errorhandling.NotFoundException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Martin Frederiksen
 */
public class WhiskyFacade {

    private static WhiskyFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private WhiskyFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static WhiskyFacade getWhiskyFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new WhiskyFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public WhiskyDTO getWhisky(long id) throws NotFoundException {
        Whisky whisky = getEntityManager().find(Whisky.class, id);
        if (whisky == null) {
            throw new NotFoundException("whisky not found");
        }
        return new WhiskyDTO(whisky);
    };
    
    public List<WhiskyDTO> getWhiskyAll() {
        return getEntityManager().createQuery("SELECT new entities.dto.WhiskyDTO(whisky) FROM Whisky whisky", WhiskyDTO.class).getResultList();
    };
    
    public void addWhisky() {
        
    };

    public void deleteWhisky() {
        
    };
    
    public void editWhisky() {
        
    };
}
