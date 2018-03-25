package com.spp.chekh.pmfrontend.view.model.factory;

import com.spp.chekh.pmfrontend.view.model.custom.DocumentStatusViewModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class ViewModelFactoryTest {

    @Test
    public void testGetDocumentViewModel() {
        final String STATUS = "TestStatus";
        final int FILE_ID = 1;
        ViewModelFactory viewModelFactory = new ViewModelFactory();
        DocumentStatusViewModel documentStatusViewModel = viewModelFactory.getDocumentViewModel(FILE_ID, STATUS);

        assertNotNull(documentStatusViewModel);
        assertEquals(documentStatusViewModel.getFileId(), String.valueOf(FILE_ID));
        assertEquals(documentStatusViewModel.getStatus(), STATUS);
    }
}