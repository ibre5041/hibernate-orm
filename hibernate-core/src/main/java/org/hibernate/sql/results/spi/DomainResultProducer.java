/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.sql.results.spi;

import org.hibernate.NotYetImplementedFor6Exception;

/**
 * Represents something that can produce a {@link DomainResult}
 * instances which can be used as selection items and
 * dynamic-instantiation args in a domain query.
 *
 * @author Steve Ebersole
 */
public interface DomainResultProducer<T> {
	/**
	 * Produce the domain query
	 */
	DomainResult<T> createDomainResult(
			int valuesArrayPosition,
			String resultVariable,
			DomainResultCreationState creationState);

	/**
	 * Used when this producer is a selection in a sub-query.  The
	 * DomainResult is only needed for root query of a SELECT statement.
	 *
	 * This default impl assumes this producer is a true (Sql)Expression
	 */
	default void applySqlSelections(DomainResultCreationState creationState) {
		throw new NotYetImplementedFor6Exception( getClass() );
//		// this form works for basic-valued nodes
//		creationState.getSqlExpressionResolver().resolveSqlSelection(
//				(Expression) this,
//				( (Expression) this ).getType().getJavaTypeDescriptor(),
//				creationState.getSqlAstCreationState().getCreationContext().getDomainModel().getTypeConfiguration()
//		);
	}
}