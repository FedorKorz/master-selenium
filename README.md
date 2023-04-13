1. BaseElement / BaseForm changed to abstract

2. findElem() in BaseElement.java has been removed

3. Frame.java is a sub of BaseForm

4. Row is now a TableElement, and the Table is a form.

5. Redundant  getTextFromLabel() is removed6. All locators are re-written

6. Methods for processing alerts are put in a separate class.

7. The driver object creation logic is implemented within the Driver (Singleton) class.

8. Logs put before steps

9. Locators are put in elements or fields.

10. Method checkIfTableHasEnteredData() has moved to @Test class

11. Specific browser methods have moved to BrowserUtil13. All unnecessary strings have been removed

12. Added specific Utilities Classes


Fixes after review