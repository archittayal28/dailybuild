Page Title: Central Authentication Service

#Object Definitions
====================================================================================
username            xpath           //input[@id='focusedInput']
password            xpath           //input[@id='password']
btn_signin          xpath           //button[@class='btn btn-primary btn-raised login']
====================================================================================

@all
--------------------------------
txt_errormsg
    above: inp_username > 10 px
    
@fail
--------------------------------
txt_errormsg
    below: inp_username > 10 px