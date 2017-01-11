Page Title: Central Authentication Service

#Object Definitions
====================================================================================
load_spinner            xpath               //div[@class='spinner']
alert                   xpath               //div[@id='step-0']
end_tour                xpath               //button[text()='End tour']
platform                xpath               //h4[contains(text(),'${value}')]
show_environment        xpath               //a[text()='${value}']
action_button           xpath               //button[@id='dropdownMenu1']
edit_Platform           xpath               //a[text()='Edit Platform']
foundation_settings     xpath               //a[text()='Foundation Settings']
artifact_button         xpath               //div[text()='Artifacts']
select_artifact         xpath               //span[text()='${value}']
current_build           css                 .form-group.artifact-versions.col-sm-9>span
label                   xpath               //label[text()='${value}']/..//span[text()='Artifact']
cancel_btn              xpath               //label[text()='Cancel']
environment             xpath               //select[@ng-model='selectedEnvironment']
====================================================================================

@all
--------------------------------
txt_errormsg
    above: inp_username > 10 px
    
@fail
--------------------------------
txt_errormsg
    below: inp_username > 10 px