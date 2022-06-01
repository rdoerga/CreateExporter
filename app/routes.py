from flask import render_template
from app import app

@app.route('/')
def index():
	return render_template('index.html',title='Volt Sandbox')

@app.route('/createExporter')
def createExporter():
	return render_template('createExporter.html',title='Volt Sandbox create exporter')

@app.route('/createImporter')
def createImporter():
	return render_template('createImporter.html',title='Volt Sandbox create importer')

@app.route('/createTable')
def createTable():
	return render_template('createTable.html',title='Volt Sandbox create table')

@app.route('/topmenu')
def topmenu():
	return render_template('topmenu.html')