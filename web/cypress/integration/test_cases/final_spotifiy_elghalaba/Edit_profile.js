// / <reference types="Cypress" />
let password = '20119820'
describe('login', () => {
    beforeEach(() => { // runs once before all tests in the block
        cy.visit('https://spotify-elghalaba.me/');
        cy.get('.v-btn__content').eq(2).click();
        cy.get('#emailField').type('mohamed.sayed8899@hotmail.com');
        cy.get('#passwordField').type(password);
        cy.get('.v-btn__content').contains('Log In').click();
        cy.wait(3000)//wait for response 
        cy.get("#inner-user-btn").click();

        cy.wait(500)//wait for response 
    });

    {
        it('change name', () => {
            cy.get('.v-list-item__title').contains("Account").click();
            cy.wait(500);//wait for response 
            cy.get('a').eq(5).click();//edit profile
            cy.get('#nameField').type('omar');
            cy.get('#saveBtn').click();
        });

    }


    {
        it('change date', () => {
            cy.get('.v-list-item__title').contains("Account").click();
            cy.wait(500);//wait for response 
            cy.get('a').eq(5).click();//edit profile
            cy.get('.v-select__selections').eq(0).click();
            cy.get('.v-list-item__content').eq(0).click();
            cy.get('#dobDayField').type(30);
            cy.get('.v-select__selections').eq(1).click();
            cy.get('.v-list-item__title').contains('January').click();//January
            cy.get('#dobYearField').type('2000');//year
            cy.get('#saveBtn').click();
            cy.get(".body-1").eq(2).should('contain', '30/1/00')

        });

    }

    {
        it('change country', () => {
            cy.get('.v-list-item__title').contains("Account").click();
            cy.wait(500);//wait for response 
            cy.get('a').eq(5).click();//edit profile
            cy.get('.v-select__selections').eq(2).click();
            cy.get('.v-list-item__title').contains('Algeria').click(); //Algeria
            cy.get('#saveBtn').click();
            cy.get(".body-1").eq(3).should('contain', 'DZ')

        });

    }
    {
        it('change phone', () => {
            cy.get('.v-list-item__title').contains("Account").click();
            cy.wait(500);//wait for response 
            cy.get('a').eq(5).click();//edit profile
            cy.get('#phoneField').type('+201112773653');
            cy.get('#saveBtn').click();
        });

    }



});


/*
                cy.visit('https://www.spotify.com/eg-en/');
                cy.get('a').contains('Log In').click();
                cy.get('input').eq(0).type('mohamed.sayed8899@hotmail.com');
                cy.get('input').eq(1).type('123456788');
                cy.get('#login-button').click();
                cy.wait(4000);
                cy.get('span').contains('Profile').click();
                cy.get('a').contains('Account').click();
                cy.wait(1000);
                cy.get('.CTA__root--3drmT CTA__secondary--FVl7a').contains('Edit Profile');

                cy.get('#profile_email').type('mohamed.sayed88@hotmail.com')
                cy.get('#profile_birthdate_month').select(10);
                cy.get('#profile_birthdate_day').select(10);
                cy.get('#profile_birthdate_year').select('2000');
                cy.get('#profile_mobile_number').type('01112773653');
                cy.get('#profile_save_profile').click();
 */