package org.shl.selenium.va.test;

import org.junit.Test;
import org.shl.selenium.va.pages.candidate.CandidateDocument;
import org.shl.selenium.va.pages.cms.CMSLanding;
import org.shl.selenium.va.pages.cms.files.CMSFilesLanding;
import org.shl.selenium.va.pages.cms.files.CMSFilesUpload;

public class CMSFilesTests extends CmsTestMain {

    // Page Objects
    private CMSLanding objCMSLanding;
    private CMSFilesLanding objCMSFilesLanding;
    private CMSFilesUpload objCMSFilesUpload;
    private CandidateDocument objCandidateDocument;

    public CMSFilesTests() {
        setTestUrl(CMS_URL);
    }

    /**
     * Test to check that file can be uploaded. 1. Open URL 2. Enter username 3.
     * Enter password 4. Click log-in 5. Click Files 6. Click Upload. 7. Upload file
     * and click save 8. Check that file is visible.
     */
    @Test
    public void uploadCMSfile() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSFilesLanding = new CMSFilesLanding(driver);
        objCMSFilesUpload = new CMSFilesUpload(driver);
        objCandidateDocument = new CandidateDocument(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openFiles();
        objCMSFilesLanding.openUpload();
        objCandidateDocument.uploadPdf();
        objCandidateDocument.checkUploadedPdf();
        objCandidateDocument.getUploadedPDF();

    }

    /**
     * Test to check if Upload can be closed. 1. Open URL 2. Enter username 3. Enter
     * password 4. Click log-in 5. Click Files 6. Click Upload. 7. Click close
     * button
     */
    @Test
    public void backFromUpload() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSFilesLanding = new CMSFilesLanding(driver);
        objCMSFilesUpload = new CMSFilesUpload(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openFiles();
        objCMSFilesLanding.openUpload();
        objCMSFilesUpload.clickClose();
    }
}