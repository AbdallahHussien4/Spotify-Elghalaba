/// <reference types="cypress" />
{
    describe('signup_form', function () {
        beforeEach(() => { // runs once before all tests in the block
            cy.visit('https://spotify-elghalaba.me/');
            cy.get('.v-btn__content').eq(3).click();
        });

        it('empty_confirm_email!', function () {
            cy.get('#emailField').type('SA2@gmail.com');
            cy.get("#signupBtn").contains('Sign Up').click();
            cy.url().should('contain', 'signup');
        })
        it('empty_password!', function () {
            cy.get('#emailField').type('SA2@gmail.com');
            cy.get('#confirmEmailField').type('SA2@gmail.com');
            cy.get("#signupBtn").contains('Sign Up').click();
            cy.url().should('contain', 'signup');

        })
        it('empty_displayname!', function () {
            cy.get('#emailField').type('SA2@gmail.com');
            cy.get('#confirmEmailField').type('SA2@gmail.com');
            cy.get('#passwordField').type('12345678');
            cy.get("#signupBtn").contains('Sign Up').click();
            cy.url().should('contain', 'signup');

        })
        it('empty_date!', function () {
            cy.get('#emailField').type('SA2@gmail.com');
            cy.get('#confirmEmailField').type('SA2@gmail.com');
            cy.get('#passwordField').type('12345678');
            cy.get('#nameField').type('mido');
            cy.get("#signupBtn").contains('Sign Up').click();
            cy.url().should('contain', 'signup');

        })
        it('full! done', function () {
            cy.get('#emailField').type('SA23345@gmail.com');
            cy.get('#confirmEmailField').type('SA23345@gmail.com');
            cy.get('#passwordField').type('12345678');
            cy.get('#nameField').type('mido');
            cy.get('#dobDayField').type('20');
            cy.get('.v-select__selections').click();
            cy.get('.v-list-item__title').eq(10).click();
            cy.get('#dobYearField').type('1998');
            cy.get("#signupBtn").contains('Sign Up').click();
            cy.url().should('contain', 'home');

        })
        it('sign up with previous email', function () {
            cy.get('#emailField').type('SA23345@gmail.com');
            cy.get('#confirmEmailField').type('SA23345@gmail.com');
            cy.get('#passwordField').type('12345678');
            cy.get('#nameField').type('mido');
            cy.get('#dobDayField').type('20');
            cy.get('.v-select__selections').click();
            cy.get('.v-list-item__title').eq(10).click();
            cy.get('#dobYearField').type('1998');
            cy.get("#signupBtn").contains('Sign Up').click();
            cy.url().should('contain', 'signup');

        })
    })

}


