/**
 *
 */
package mz.co.msaude.boot.frameworks.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import mz.co.msaude.boot.frameworks.exception.BusinessException;

/**
 * @author Stélio Moiane
 *
 */
@Transactional(rollbackOn = BusinessException.class, value = TxType.SUPPORTS)
public abstract class AbstractService {

}
