package com.spp.chekh.pmfrontend.view.model.factory;

import com.spp.chekh.pmfrontend.view.model.custom.DocumentStatusViewModel;
import org.springframework.stereotype.Component;

@Component
public class ViewModelFactory {

    public DocumentStatusViewModel getDocumentViewModel(int fileId, String status){
        DocumentStatusViewModel documentStatusViewModel = new DocumentStatusViewModel();
        documentStatusViewModel.setFileId(String.valueOf(fileId));
        documentStatusViewModel.setStatus(status);
        return documentStatusViewModel;
    }
}
