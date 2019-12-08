package Contract;

/**
 * Donne le contrat entre la View et le presenteur
 */
public interface MainContract {
    interface MvpView {
        void setSectionTitle(String letter);
        void setIsActif(boolean isActif);
    }

    interface MvpPresentateur{
    }
}
