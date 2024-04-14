/**
 *
 */
package mz.co.msaude.boot.frameworks.service;

import javax.transaction.Transactional;

import mz.co.msaude.boot.frameworks.exception.BusinessException;

/**
 * @author Stélio Moiane
 *
 */
@Transactional(rollbackOn = BusinessException.class)
public abstract class AbstractService {

}
