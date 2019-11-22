package Presenter;

public class Pres_SectionMetier_Student implements Pres_SectionMetier{

    @Override
    public void SaveChanges() {

    }

    @Override
    public void LoadContent() {

    }


    public interface View{
        void UpdateViews();
        void UpdateProgressionBar();
        void ShowCamera();
        void ShowConfirmDialog();
        void AccessGallery();
        void ZoomPict();
        void ListenComment();
    }
}
