<%@include file="cabecalho.jsp"%>
					
					<div class="row">
						<div class="col-md-1">
						</div>
						<div class="col-md-10">
							
							<div class="panel panel-default">
								<div class="panel-heading">
									<h2 class="panel-title">
										Cadastro de Veterinario
									</h2>
								</div>
								<div class="panel-body">
									<!-- formulário de cadastro de Veterinario -->
									<form action="VeterinarioServlet" method="post">
										<fieldset>
											<div class="form-group">
												<label for="crv">CRV</label>
												<input type="text" class="form-control" 
												id="crv" name="crv" autofocus
												placeholder="99999">
											
												<label for="nome">Nome Completo</label>
												<input type="text" class="form-control" 
												id="nome" name="nome" autofocus
												placeholder="Insira seu nome">
												
												<label>Cidade</label>
												<select name="cidade" class="form-control">
													<option value="">Selecione</option>
													<option value="tagua">Taguatinga</option>
													<option value="guara">Guará</option>
													<option value="cei">Ceilândia</option>
												</select>
												
												<label for="endereco">Endereço</label>
												<input type="text" name="endereco"
												id="endereco" class="form-control"
												placeholder="Logradouro">
												
												<label for="telefone">Telefone</label>
												<input type="tel" name="telefone"
												id="telefone" class="form-control"
												placeholder="(61) 9.9999-9999">		
												
												<label for="celular">Celular</label>
												<input type="tel" name="celular"
												id="celular" class="form-control"
												placeholder="(61) 9.9999-9999">										
												
												<label for="cpf">CPF</label>
												<input type="tel" name="cpf"
												id="cpf" class="form-control"
												placeholder="999.999.999-99">
												
											</div>	
											<button	type="submit" class="btn btn-primary">								
												Gravar
											</button>
										</fieldset>
									</form>
								</div>
							</div>
							
						</div>
					</div>
					
				</div>
			</div>
		</div>
		</body>
		</html>		
		
		
				