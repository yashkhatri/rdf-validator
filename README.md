# rdf-validator
A RDF validation api created to validate the RDF data. 

This project includes methods that reads the validation constraints on the java pojo classes set in the form of annotations. 

+ Creates JenaModel from these pojos.
+ Creates Shapes Mode from the annotations.
+ Validates the Data Model against the Shapes Model and returns result.

Uses the underlying SHACLeX library by Labra for validating the RDF data.
