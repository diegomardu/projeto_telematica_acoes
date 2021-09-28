$('#confimacaoExclusaoModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	
	var codigoAcao = button.data('codigo');
	var descricaoAcao = button.data('descricao');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if (!action.endsWith('/')) {
		action += '/';
	}
	form.attr('action', action + codigoAcao);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir a ação <strong>' + descricaoAcao + '</strong>?');
});