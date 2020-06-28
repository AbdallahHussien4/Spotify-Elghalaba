// / <reference types="Cypress" />
let email = 'loaywael22@outlook.com'
let password = 'MohamedSayed20'
let newpassword = 'MohamedSayed201'
let fakepassword = 'fakepassword123'

describe('Change Password', () => {
    beforeEach(() => { // runs once before all tests in the block
        cy.visit('https://www.spotify.com/eg-en/');
        cy.get('a').contains('Log In').click();
        cy.get('#login-username').type(email);
        cy.get('#login-password').type(password);
        cy.get('#login-button').click();
        cy.wait(3000)//wait for response 
        cy.get("a").contains('Change password').click();
        cy.wait(500)//wait for response 
    });

    {
        it('Wrong Current password', () => {
            cy.get('#change_password_validatePassword').type(fakepassword);
            cy.get('#change_password_new_password').type(newpassword);
            cy.get('#change_password_check_password').type(newpassword);
            cy.get('#change_password_submit').click();//edit profile
            cy.wait(1000);
            cy.get('label').contains('Sorry, wrong password');
        });
    }
    {
        it('Wrong Confirmation', () => {
            cy.get('#change_password_validatePassword').type(password);
            cy.get('#change_password_new_password').type(newpassword);
            cy.get('#change_password_check_password').type('wrongconfirmation');
            cy.get('#change_password_submit').click();//edit profile
            cy.wait(1000);
            cy.get('label').contains('Please verify your password');
        });
    }
    {
        it('Change it', () => {
            cy.get('#change_password_validatePassword').type(password);
            cy.get('#change_password_new_password').type(newpassword);
            cy.get('#change_password_check_password').type(newpassword);
            cy.get('#change_password_submit').click();//edit profile
            cy.wait(1000);
            cy.get('div').contains('Password updated');
        });
    }

});


