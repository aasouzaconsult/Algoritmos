from flask import Flask, render_template, request, redirect
import psycopg2

app = Flask(__name__, template_folder='templates')

# app = Flask(__name__)

# Configurações do banco de dados
db_config = {
    'host': 'localhost',
    'port': '5432',
    'database': 'db_teste',
    'user': 'postgres',
    'password': '@@$150581z@@$'
}

# Conexão com o banco de dados
conn = psycopg2.connect(**db_config)
cursor = conn.cursor()

# Rota para exibir os registros da tabela
@app.route('/')
def index():
    # Consulta os registros da tabela
    cursor.execute("SELECT * FROM tabela_crud")
    records = cursor.fetchall()
    return render_template('index.html', records=records)

# Rota para adicionar um novo registro
@app.route('/add', methods=['POST'])
def add():
    if request.method == 'POST':
        name = request.form['name']
        email = request.form['email']
        
        # Insere um novo registro na tabela
        cursor.execute("INSERT INTO tabela_crud (name, email) VALUES (%s, %s)", (name, email))
        conn.commit()
        
    return redirect('/')

# Rota para editar um registro existente
@app.route('/edit/<int:id>', methods=['GET', 'POST'])
def edit(id):
    cursor.execute("SELECT * FROM tabela_crud WHERE id = %s", (id,))
    record = cursor.fetchone()

    if request.method == 'POST':
        name = request.form['name']
        email = request.form['email']
        
        # Atualiza o registro na tabela
        cursor.execute("UPDATE tabela_crud SET name = %s, email = %s WHERE id = %s", (name, email, id))
        conn.commit()
        
        return redirect('/')
    
    return render_template('edit.html', record=record)

# Rota para excluir um registro
@app.route('/delete/<int:id>')
def delete(id):
    # Exclui o registro da tabela
    cursor.execute("DELETE FROM tabela_crud WHERE id = %s", (id,))
    conn.commit()
    
    return redirect('/')

if __name__ == '__main__':
    app.run(debug=True)
